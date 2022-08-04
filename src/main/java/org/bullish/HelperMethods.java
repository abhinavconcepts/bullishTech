package org.bullish;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class HelperMethods {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    String host = Config.localhost;
    String response_text;

    public String addStudent(String json)  {
        try{
            String path = Config.add_student_api_path;

            HttpPost post = new HttpPost(host + path);

            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(post)) {
                response_text = EntityUtils.toString(response.getEntity());
            }
            httpClient.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
        return response_text;
    }

    public String fetchStudents(String queryStringParameters)  {
        try{
            String path = Config.fetch_student_api_path;

            HttpGet get = new HttpGet(host + path + "?" + queryStringParameters);

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(get)) {
                response_text = EntityUtils.toString(response.getEntity());
            }
            httpClient.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
        return response_text;
    }

    public String updateStudent(String json)  {
        try{
            // This can be moved to an external config file in case the endpoint changes in the future
            String path = Config.update_student_api_path;

            HttpPut put = new HttpPut(host + path);

            StringEntity entity = new StringEntity(json);
            put.setEntity(entity);
            put.setHeader("Accept", "application/json");
            put.setHeader("Content-type", "application/json");

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(put)) {
                response_text = EntityUtils.toString(response.getEntity());
            }
            httpClient.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
        return response_text;
    }

    private static class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "DELETE";
        public String getMethod() { return METHOD_NAME; }

        public HttpDeleteWithBody(final String uri) {
            super();
            setURI(URI.create(uri));
        }
        public HttpDeleteWithBody(final URI uri) {
            super();
            setURI(uri);
        }
        public HttpDeleteWithBody() { super(); }
    }

    public String deleteStudent(String json)  {
        try{
            // This can be moved to an external config file in case the endpoint changes in the future
            String path = Config.delete_student_api_path;

            HttpDeleteWithBody delete = new HttpDeleteWithBody(host + path);

            StringEntity entity = new StringEntity(json);
            delete.setEntity(entity);
            delete.setHeader("Accept", "application/json");
            delete.setHeader("Content-type", "application/json");

            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(delete)) {
                response_text = EntityUtils.toString(response.getEntity());
            }
            httpClient.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
        return response_text;
    }
}
