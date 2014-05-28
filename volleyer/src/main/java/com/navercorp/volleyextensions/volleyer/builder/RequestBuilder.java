package com.navercorp.volleyextensions.volleyer.builder;

import com.navercorp.volleyextensions.volleyer.VolleyerContext;
import com.navercorp.volleyextensions.volleyer.http.HttpContent;
import com.navercorp.volleyextensions.volleyer.http.HttpMethod;
import com.navercorp.volleyextensions.volleyer.util.Assert;

public class RequestBuilder {
	private VolleyerContext volleyerContext;
	private HttpContent httpContent;

	private boolean isDoneToBuild = false;

	public RequestBuilder(VolleyerContext volleyerContext, String url, HttpMethod method) {
		Assert.notNull(volleyerContext, "VolleyerContext");

		this.volleyerContext = volleyerContext;
		httpContent = new HttpContent(url, method);
	}

	public RequestBuilder addHeader(String key, String value) {
		assertFinishState();

		httpContent.addHeader(key, value);
		return this;
	}

	private void assertFinishState() {
		if (isDoneToBuild == true) {
			throw new IllegalStateException("RequestBuilder should not be used any more. Because afterRequest() has been called.");
		}
	}

	public TargetClassBuilder afterRequest() {
		TargetClassBuilder targetClassBuilder = new TargetClassBuilder(volleyerContext, httpContent);
		isDoneToBuild = true;
		return targetClassBuilder;
	}
}
