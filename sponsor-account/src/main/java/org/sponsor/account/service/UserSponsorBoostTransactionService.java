
package org.sponsor.account.service;

import org.brijframework.integration.spring.rest.crud.service.CrudService;
import org.sponsor.account.entities.EOUserSponsorBoostTransaction;
import org.sponsor.account.model.UIUserSponsorBoostTransaction;

public interface UserSponsorBoostTransactionService extends CrudService<UIUserSponsorBoostTransaction, EOUserSponsorBoostTransaction, Long>, TransactionService{

	Boolean existsByUserSponsorIdAndStatus(Long id, String string);

}
