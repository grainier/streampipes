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

package org.apache.streampipes.model.connect.adapter;

import org.apache.streampipes.model.connect.grounding.FormatDescription;
import org.apache.streampipes.model.connect.grounding.ProtocolDescription;
import org.apache.streampipes.model.connect.grounding.ProtocolStreamDescription;
import org.apache.streampipes.model.schema.EventSchema;
import org.apache.streampipes.model.shared.annotation.TsModel;
import org.apache.streampipes.model.util.ElementIdGenerator;

@TsModel
public class GenericAdapterStreamDescription extends AdapterStreamDescription implements GenericAdapterDescription {

  public static final String ID = ElementIdGenerator.makeFixedElementId(GenericAdapterStreamDescription.class);

  private FormatDescription formatDescription;

  private ProtocolDescription protocolDescription;

  public GenericAdapterStreamDescription() {
    super(ID, "GenericAdapterStreamDescription", "");
  }

  public GenericAdapterStreamDescription(FormatDescription formatDescription,
                                         ProtocolStreamDescription protocolDescription) {
    this.formatDescription = formatDescription;
    this.protocolDescription = protocolDescription;
  }

  public GenericAdapterStreamDescription(GenericAdapterStreamDescription other) {
    super(other);

    if (other.getFormatDescription() != null) {
      this.formatDescription = new FormatDescription(other.getFormatDescription());
    }
    if (other.getProtocolDescription() != null) {
      this.protocolDescription = new ProtocolStreamDescription(other.getProtocolDescription());
    }
  }

  public FormatDescription getFormatDescription() {
    return formatDescription;
  }

  public void setFormatDescription(FormatDescription formatDescription) {
    this.formatDescription = formatDescription;
  }

  @Override
  public EventSchema getEventSchema() {
    if (this.getDataStream() != null) {
      return this.getDataStream().getEventSchema();
    }
    return null;
  }

  public ProtocolDescription getProtocolDescription() {
    return protocolDescription;
  }

  public void setProtocolDescription(ProtocolDescription protocolDescription) {
    this.protocolDescription = protocolDescription;
  }

}
