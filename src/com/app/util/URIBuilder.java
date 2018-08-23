package com.app.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class URIBuilder {
	private String url;
	private String uri;
	private Map<String, String> pMap;

	public URIBuilder(String fullPath) {
		url = fullPath.split("\\?")[0];
		pMap = getQueryParams(fullPath);
		uri = fullPath;
	}

	public void addParameter(String parameter, String value) {
		boolean existParam = false;
		for (Map.Entry<String, String> entry : pMap.entrySet()) {
			if (entry.getKey().equals(parameter)) {
				existParam = true;
				entry.setValue(value);
			}
		}
		if (!existParam)
			pMap.put(parameter, value);
		updateURI();
	}

	public boolean hasParameter() {
		return pMap.size() > 0;
	}

	// update should be the final process
	private void updateURI() {
		if (pMap.size() == 0)
			uri = url;
		else {
			uri = url + "?";
			for (Map.Entry<String, String> entry : pMap.entrySet()) {
				uri += entry.getKey() + "=" + entry.getValue() + "&";
			}
			uri = uri.substring(0, uri.length() - 1);
		}
	}

	private Map<String, String> getQueryParams(String url) {
		try {
			Map<String, String> params = new LinkedHashMap<String, String>();
			String[] urlParts = url.split("\\?");
			if (urlParts.length > 1) {
				String query = urlParts[1];
				for (String param : query.split("&")) {
					String[] pair = param.split("=");
					String key = URLDecoder.decode(pair[0], "UTF-8");
					String value = "";
					if (pair.length > 1) {
						value = URLDecoder.decode(pair[1], "UTF-8");
						params.put(key, value);
					}
				}
			}

			return params;
		} catch (UnsupportedEncodingException ex) {
			throw new AssertionError(ex);
		}
	}
	public String getParameterVal(String parameterKey) {
		return pMap.get(parameterKey);
	}
	public String getURI() {
		return uri;
	}
}
