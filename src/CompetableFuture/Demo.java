package CompetableFuture;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        Executor executor = Executors.newSingleThreadExecutor();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.amazon.com"))
                .build();

        Instant before = Instant.now();
        CompletableFuture<Void> start = new CompletableFuture<>();
        CompletableFuture<HttpResponse<String>> future =
                start
                        .thenCompose(nil ->
                                client.sendAsync(request, HttpResponse.BodyHandlers.ofString()));


        future.thenAcceptAsync(
                        response -> {
                            String body = response.body();
                            System.out.println("body = " + body.length() + " Thread " + Thread.currentThread().getName());
                        }, executor)
                .thenRun(() -> System.out.println("Done! "));

        start.complete(null);
        Instant after = Instant.now();
        Duration dur = Duration.between(before, after);
        System.out.println(dur.toMillis());
        Thread.sleep(6000);
        ((ExecutorService) executor).shutdown();


    }

    public Demo() throws IOException, InterruptedException {
    }
}
