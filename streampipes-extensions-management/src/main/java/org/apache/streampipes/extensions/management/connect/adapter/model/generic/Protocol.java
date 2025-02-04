/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.streampipes.extensions.management.connect.adapter.model.generic;

import org.apache.streampipes.extensions.api.connect.IFormat;
import org.apache.streampipes.extensions.api.connect.IParser;
import org.apache.streampipes.extensions.api.connect.IProtocol;
import org.apache.streampipes.model.schema.EventSchema;

public abstract class Protocol implements IProtocol {

  protected IParser parser;
  protected IFormat format;

  //TODO remove
  protected EventSchema eventSchema;

  public Protocol() {

  }

  public Protocol(IParser parser, IFormat format) {
    this.parser = parser;
    this.format = format;
  }

  //TODO remove
  @Override
  public void setEventSchema(EventSchema eventSchema) {
    this.eventSchema = eventSchema;
  }
}
