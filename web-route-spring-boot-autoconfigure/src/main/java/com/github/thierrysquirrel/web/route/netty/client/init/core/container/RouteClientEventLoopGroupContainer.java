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
package com.github.thierrysquirrel.web.route.netty.client.init.core.container;

import com.google.common.collect.Maps;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.Map;

/**
 * ClassName: RouteClientEventLoopGroupContainer
 * Description:
 * date: 2021/5/21 22:45
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class RouteClientEventLoopGroupContainer {
	private static final Map<String, EventLoopGroup> EVENT_LOOP_GROUP_MAP = Maps.newConcurrentMap();

	private RouteClientEventLoopGroupContainer() {
	}

	public static EventLoopGroup getEventLoopGroup(String headerRouteValue) {
		return EVENT_LOOP_GROUP_MAP.computeIfAbsent(headerRouteValue, key -> new NioEventLoopGroup());
	}

}
