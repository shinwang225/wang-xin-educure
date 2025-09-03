import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main2 {
    public static void main(String[] args) {
        try {
            // 検索キーワードをCQL形式で設定
            String query = "title = Java"; // CQLフォーマット
            String encodedQuery = URLEncoder.encode(query, "UTF-8");

            // 国立国会図書館APIのエンドポイント
            String endpoint = "https://ndlsearch.ndl.go.jp/api/sru";

            // APIリクエストのURLを構築
            String requestUrl = endpoint + "?operation=searchRetrieve"
                + "&version=1.2"
                + "&query=" + encodedQuery
                + "&maximumRecords=10"
                + "&recordSchema=dc";
                
            // ここにコードを書いてください
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(requestUrl))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("status code: " + response.statusCode());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
