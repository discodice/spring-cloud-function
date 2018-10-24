/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.function.json;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.cloud.function.json.JsonMapper;
import org.springframework.core.ResolvableType;

/**
 * @author Dave Syer
 * @author Oleg Zhurakousky
 *
 */
public class GsonMapper implements JsonMapper {

	private final Gson gson;

	public GsonMapper(Gson gson) {
		this.gson = gson;
	}

	@Override
	public <T> T toObject(String json, Type type) {
		Type actualCollectionType = (json.startsWith("[") && !(type instanceof ParameterizedType))
				? ResolvableType.forClassWithGenerics(ArrayList.class, (Class<?>)type).getType()
						: type;

		return gson.fromJson(json, actualCollectionType);
	}

	@Override
	public <T> List<T> toList(String json, Class<T> type) {
		return gson.fromJson(json,
				ResolvableType.forClassWithGenerics(ArrayList.class, type).getType());
	}

	@Override
	public <T> T toSingle(String json, Class<T> type) {
		return gson.fromJson(json, type);
	}

	@Override
	public String toString(Object value) {
		return gson.toJson(value);
	}
}
