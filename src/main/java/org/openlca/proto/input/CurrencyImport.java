package org.openlca.proto.input;

import java.util.Objects;

import org.openlca.core.database.CurrencyDao;
import org.openlca.core.model.Currency;
import org.openlca.proto.Proto;

public class CurrencyImport {

  private final ImportConfig config;

  public CurrencyImport(ImportConfig config) {
    this.config = config;
  }

  public Currency of(String id) {
    if (id == null)
      return null;
    var currency = config.get(Currency.class, id);

    // check if we are in update mode
    var update = false;
    if (currency != null) {
      if (config.isHandled(currency)
        || config.noUpdates())
        return currency;
      update = true;
    }

    // check the proto object
    var proto = config.store.getCurrency(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(currency, wrap))
        return currency;
    }

    // map the data
    if (currency == null) {
      currency = new Currency();
    }
    wrap.mapTo(currency, config);
    map(proto, currency);

    // insert it
    var dao = new CurrencyDao(config.db);
    currency = update
      ? dao.update(currency)
      : dao.insert(currency);
    config.putHandled(currency);
    return currency;
  }

  private void map(Proto.Currency proto, Currency currency) {
    currency.code = proto.getCode();
    currency.conversionFactor = proto.getConversionFactor();
    var refCurrencyID = proto.getReferenceCurrency().getId();
    if (Objects.equals(refCurrencyID, proto.getId())) {
      currency.referenceCurrency = currency;
    } else {
      currency.referenceCurrency = of(refCurrencyID);
    }
  }
}

