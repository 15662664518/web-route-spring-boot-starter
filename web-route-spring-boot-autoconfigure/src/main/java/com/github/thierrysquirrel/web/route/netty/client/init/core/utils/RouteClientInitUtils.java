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
package com.github.thierrysquirrel.web.route.netty.client.init.core.utils;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;

/**
 * ClassName: RouteClientInitUtils
 * Description:
 * date: 2021/5/21 22:52
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RouteClientInitUtils {
	private RouteClientInitUtils() {
	}

	public static DefaultFullHttpResponse convertDefaultFullHttpResponse(FullHttpResponse response) {
		return new DefaultFullHttpResponse(response.protocolVersion(), response.status(),
				response.content().retain(),
				response.headers(),
				response.trailingHeaders());
	}
}
