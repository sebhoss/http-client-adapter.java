package de.xn__ho_hia.adapters.http.client.okhttp3;

import java.util.Locale;
import java.util.function.Function;

import ch.qos.cal10n.IMessageConveyor;
import ch.qos.cal10n.MessageConveyor;
import de.xn__ho_hia.adapters.http.client.HttpClient;
import de.xn__ho_hia.adapters.http.client.factory.HttpClientFactory;
import de.xn__ho_hia.memoization.map.MapMemoize;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

final class OkHttp3HttpClientFactory implements HttpClientFactory {

    private OkHttpClient                client;
    private Function<String, MediaType> mediaTypeCreator;
    private IMessageConveyor            messages;

    @Override
    public HttpClient buildHttpClient() {
        if (client == null) {
            rebuildClient();
        }
        if (mediaTypeCreator == null) {
            rebuildMediaTypeCreator();
        }
        if (messages == null) {
            rebuildMessageConveyor();
        }
        return new OkHttp3HttpClientAdapter(client, mediaTypeCreator, messages);
    }

    private void rebuildClient() {
        client = new OkHttpClient();
    }

    private void rebuildMediaTypeCreator() {
        mediaTypeCreator = MapMemoize.function(MediaType::parse);
    }

    private void rebuildMessageConveyor() {
        messages = new MessageConveyor(Locale.ENGLISH);
    }

}
