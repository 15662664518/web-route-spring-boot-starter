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
package com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.execution;

import com.github.thierrysquirrel.web.route.core.builder.constant.ThreadPoolExecutorConstant;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.factory.domain.RelayHttpRequest;
import com.github.thierrysquirrel.web.route.netty.server.handler.core.thread.execute.WebRouteBusinessThreadExecute;
import io.netty.channel.Channel;

/**
 * ClassName: WebRouteBusinessExecution
 * Description:
 * date: 2021/5/21 23:56
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class WebRouteBusinessExecution {
	private WebRouteBusinessExecution() {
	}

	public static void business(String headerRouteKey, RelayHttpRequest request, int maxContentLength, Channel serverChannel) {
		var businessThreadExecute = new WebRouteBusinessThreadExecute(headerRouteKey, request, maxContentLength, serverChannel);
		ThreadPoolExecutorConstant.WEB_ROUTE_BUSINESS.execute(businessThreadExecute);
	}
}
