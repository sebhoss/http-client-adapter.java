/*
 * This file is part of http-client-adapter. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of http-client-adapter,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.hc4j.okhttp3;

import wtf.metio.hc4j.HttpClient;
import wtf.metio.hc4j.factory.HttpClientBuilder;
import wtf.metio.hc4j.factory.HttpClientFactory;

final class OkHttp3HttpClientFactory implements HttpClientFactory {

    @Override
    public HttpClient buildHttpClient() {
        return client().buildHttpClient();
    }

    @Override
    public HttpClientBuilder client() {
        return new OkHttp3HttpClientBuilder();
    }

}
