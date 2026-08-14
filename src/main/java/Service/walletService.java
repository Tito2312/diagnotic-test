package Service;

import Model.transaction;
import Model.wallet;

import java.util.UUID;

public class walletService {

    public wallet createWallet(){

        String walletId = UUID.randomUUID().toString();

        return new wallet(walletId);
    }

    public wallet getWallet(String walletId){
        return new wallet(walletId);
    }

    public void decreaseBalance(float amount){

    }
}
