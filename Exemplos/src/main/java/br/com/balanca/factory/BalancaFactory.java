package br.com.balanca.factory;

import br.com.balanca.enums.TipoBalanca;
import br.com.balanca.interfaces.IBalanca;
import br.com.balanca.models.Produto;
import br.com.balanca.services.FilizolaSmart;
import br.com.balanca.services.ToledoMGV6;
import br.com.balanca.services.UranoIntegra;

public class BalancaFactory {
    public static IBalanca<Produto> getBalanca(TipoBalanca tipo) {

        switch (tipo) {
            case FINIZOLA_SMART:
                return new FilizolaSmart();
            case TOLEDO_MGV6:
                return new ToledoMGV6();
            case URANO_INTEGRA:
                return new UranoIntegra();
            default:
                return null;
        }
    }
}

