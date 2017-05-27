package fr.training.guice;

import static org.junit.Assert.assertEquals;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fr.training.MainVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;
import java.util.concurrent.CountDownLatch;
import org.junit.Before;
import org.junit.Test;

public class GuiceVertxDeploymentManagerTest {

  private Vertx vertx;

  private CountDownLatch lock = new CountDownLatch(1);

  @Before
  public void setUp() {
    vertx = Vertx.vertx(new VertxOptions().setMetricsOptions(
        new DropwizardMetricsOptions().setEnabled(true).setJmxEnabled(true)
            .setJmxDomain("vertx-metrics")));

    Injector injector = Guice.createInjector(new GuiceVertxBinder(vertx));
    GuiceVerticleFactory guiceVerticleFactory = new GuiceVerticleFactory(injector);
    vertx.registerVerticleFactory(guiceVerticleFactory);
  }

  @Test
  public void testDeployVerticleWithOptions() throws InterruptedException {
    GuiceVertxDeploymentManager deploymentManager = new GuiceVertxDeploymentManager(this.vertx);
    deploymentManager.deployVerticle(MainVerticle.class, new DeploymentOptions().setWorker(true));

    HttpClient client = vertx.createHttpClient();
    HttpClientRequest request = client.get("/ping", response -> {
      assertEquals(200, response.statusCode());
      response.bodyHandler(buffer -> assertEquals("Pong", buffer.toString()));
      lock.countDown();
    });
    request.putHeader("content-length", "1000");
    request.putHeader("content-type", "text/plain");
    request.write("");
  }
}
