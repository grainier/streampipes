package de.fzi.cep.sepa.manager.verification;

import de.fzi.cep.sepa.commons.exceptions.SepaParseException;
import de.fzi.cep.sepa.model.impl.graph.SecDescription;
import de.fzi.cep.sepa.storage.controller.StorageManager;

import org.apache.shiro.SecurityUtils;

public class SecVerifier extends ElementVerifier<SecDescription> {

	
	public SecVerifier(String graphData)
			throws SepaParseException {
		super(graphData, de.fzi.cep.sepa.model.impl.graph.SecDescription.class);
	}


	@Override
	protected void store(String username, boolean publicElement) {
		/*
		if (SecurityUtils.getSubject().isAuthenticated()) {
			String username = SecurityUtils.getSubject().getPrincipal().toString();
			StorageManager.INSTANCE.getUserStorageAPI().addAction(username, elementDescription.getElementId());
		}
*/
		storageApi.storeSEC(elementDescription);
		userService.addOwnAction(username, elementDescription.getUri(), publicElement);
	}

	@Override
	protected void collectValidators() {
		super.collectValidators();
	}


	@Override
	protected void update(String username) {
		storageApi.update(elementDescription);
	}

}
