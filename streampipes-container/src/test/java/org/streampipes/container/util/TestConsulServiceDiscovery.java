package org.streampipes.container.util;

import com.google.common.base.Optional;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.kv.Value;
import com.orbitz.consul.option.QueryOptions;

import java.util.List;

import static org.streampipes.container.util.ConsulUtil.getPEServices;

public class TestConsulServiceDiscovery {

     public static void main(String[] args) throws UnirestException {
     /*   ConsulServiceDiscovery.registerPeService("t2",
                                                    "t2",
                                                        "http://141.21.14.94",
                                                        8090);
                                                        */
         //getActivePEServicesRdfEndPoints();
        // subcribeHealthService();
        // while(true) ;
          getPEServices();

          Consul consul = ConsulUtil.consulInstance();

          KeyValueClient keyValueClient = consul.keyValueClient();
         // List<String> keys = keyValueClient.getKeys("sp/v1/pe/org.streampipes.pe.mixed.flink/elasticsearch_host");;
          ConsulResponse<List<Value>> consulResponseWithValues = keyValueClient.getConsulResponseWithValues("pe/org.streampipes.pe.mixed.flink");
//          String valueAsString = consulResponseWithValues.getResponse().get(1).getValueAsString().get();

         // List<String> valuesAsString = keyValueClient.getValuesAsString("sp/v1/pe/org.streampipes.pe.mixed.flink/elasticsearch_host");
        //  System.out.println("asd");

     }
}
