package Service;

import Model.wallet;

import java.util.UUID;

public class walletService {

    public wallet createWallet(){

        String walletId = UUID.randomUUID().toString();

        return new wallet(walletId);
    }

}
