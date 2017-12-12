package org.streampipes.container.embedded.init;

import org.streampipes.container.init.ModelSubmitter;
import org.streampipes.container.model.PeConfig;
import org.streampipes.container.util.ConsulUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public abstract class ContainerModelSubmitter extends ModelSubmitter implements ServletContextListener {

//
//    /**
//     * This Method needs to be implemented to instantiate an client container
//     * Use the DeclarersSingleton to register the declarers
//     */
    public abstract void init();

    public void init(PeConfig peConfig) {
        ConsulUtil.registerPeService(
                peConfig.getId(),
                peConfig.getHost(),
                peConfig.getPort()
        );
    }

    @Override
    public void contextInitialized(ServletContextEvent arg) {
        init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
