/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.function.context;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Oleg Zhurakousky
 * @since 3.0
 *
 */
@ConfigurationProperties(prefix = FunctionProperties.PREFIX)
public class FunctionProperties {

	/**
	 * The name prefix for properties defined by this properties class.
	 */
	public final static String PREFIX = "spring.cloud.function";

	/**
	 * Definition of the function to be used. This could be function name (e.g., 'myFunction')
	 * or function composition definition (e.g., 'myFunction|yourFunction')
	 */
	private String definition;

	private String routingExpression;

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getRoutingExpression() {
		return routingExpression;
	}

	public void setRoutingExpression(String routingExpression) {
		this.routingExpression = routingExpression;
	}
}
