/**
 * Copyright 2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.thierrysquirrel.web.route.netty.server.handler.core.factory;

import com.github.thierrysquirrel.web.route.core.template.domain.WebRelayMessage;
import com.github.thierrysquirrel.web.route.netty.client.init.core.factory.execution.RouteClientAsynchronousRequestExecution;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.RelayHttpRequest;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.builder.utils.RelayHttpRequestUtils;
import io.netty.channel.Channel;

/**
 * ClassName: RouteFactory
 * Description:
 * date: 2021/5/21 23:41
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RouteFactory {
	private RouteFactory() {
	}

	public static void route(String headerRouteKey, RelayHttpRequest request, WebRelayMessage webRelayMessage, int maxContentLength, Channel serverChannel) {
		String headerRouteValue = request.getHeaders().get(headerRouteKey);
		var httpRequest = RelayHttpRequestUtils.convertDefaultFullHttpRequest(request);
		RouteClientAsynchronousRequestExecution.asynchronousRequest(webRelayMessage.getUrl(), maxContentLength, headerRouteValue, httpRequest, serverChannel, webRelayMessage.getRelayErrorMessage());
	}
}
