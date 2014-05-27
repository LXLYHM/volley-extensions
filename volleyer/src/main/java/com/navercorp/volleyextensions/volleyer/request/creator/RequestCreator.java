package com.navercorp.volleyextensions.volleyer.request.creator;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.navercorp.volleyextensions.volleyer.http.HttpContent;
import com.navercorp.volleyextensions.volleyer.response.parser.NetworkResponseParser;

public interface RequestCreator {
	<T> Request<T> createRequest(HttpContent httpContent, Class<T> clazz,
			NetworkResponseParser responseParser, Listener<T> listener,
			ErrorListener errorListener);
}
