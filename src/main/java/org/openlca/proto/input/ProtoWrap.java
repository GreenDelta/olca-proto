package org.openlca.proto.input;

import com.google.protobuf.ProtocolStringList;
import org.openlca.core.model.CategorizedEntity;
import org.openlca.core.model.Version;
import org.openlca.jsonld.Json;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

abstract class ProtoWrap {

  abstract String id();

  abstract String name();

  abstract String description();

  abstract String version();

  abstract String lastChange();

  abstract Proto.Ref category();

  abstract ProtocolStringList tags();

  abstract String library();

  void mapTo(CategorizedEntity e, ImportConfig config) {
    if (e == null)
      return;

    // root entity fields
    e.refId = id();
    e.name = name();
    e.description = description();
    var version = version();
    if (Strings.notEmpty(version)) {
      e.version = Version.fromString(version).getValue();
    }
    if (Strings.notEmpty(lastChange())) {
      var date = Json.parseDate(lastChange());
      e.lastChange = date != null
        ? date.getTime()
        : 0;
    }

    // categorized entity fields
    var catID = category().getId();
    if (Strings.notEmpty(catID)) {
      e.category = new CategoryImport(config).of(catID);
    }
    e.tags = tags()
      .stream()
      .reduce((tag, tags) -> tags + "," + tag)
      .orElse(null);
    e.library = Strings.notEmpty(library())
      ? library()
      : null;

  }

  static ProtoWrap of(Proto.Category proto) {
    return new ProtoWrap() {
      @Override
      String id() {
        return proto.getId();
      }

      @Override
      String name() {
        return proto.getName();
      }

      @Override
      String description() {
        return proto.getDescription();
      }

      @Override
      String version() {
        return proto.getVersion();
      }

      @Override
      String lastChange() {
        return proto.getLastChange();
      }

      @Override
      Proto.Ref category() {
        return proto.getCategory();
      }

      @Override
      ProtocolStringList tags() {
        return proto.getTagsList();
      }

      @Override
      String library() {
        return proto.getLibrary();
      }
    };
  }

  static ProtoWrap of(Proto.Actor proto) {
    return new ProtoWrap() {
      @Override
      String id() {
        return proto.getId();
      }

      @Override
      String name() {
        return proto.getName();
      }

      @Override
      String description() {
        return proto.getDescription();
      }

      @Override
      String version() {
        return proto.getVersion();
      }

      @Override
      String lastChange() {
        return proto.getLastChange();
      }

      @Override
      Proto.Ref category() {
        return proto.getCategory();
      }

      @Override
      ProtocolStringList tags() {
        return proto.getTagsList();
      }

      @Override
      String library() {
        return proto.getLibrary();
      }
    };
  }

  static ProtoWrap of(Proto.Source proto) {
    return new ProtoWrap() {
      @Override
      String id() {
        return proto.getId();
      }

      @Override
      String name() {
        return proto.getName();
      }

      @Override
      String description() {
        return proto.getDescription();
      }

      @Override
      String version() {
        return proto.getVersion();
      }

      @Override
      String lastChange() {
        return proto.getLastChange();
      }

      @Override
      Proto.Ref category() {
        return proto.getCategory();
      }

      @Override
      ProtocolStringList tags() {
        return proto.getTagsList();
      }

      @Override
      String library() {
        return proto.getLibrary();
      }
    };
  }

  static ProtoWrap of(Proto.Currency proto) {
    return new ProtoWrap() {
      @Override
      String id() {
        return proto.getId();
      }

      @Override
      String name() {
        return proto.getName();
      }

      @Override
      String description() {
        return proto.getDescription();
      }

      @Override
      String version() {
        return proto.getVersion();
      }

      @Override
      String lastChange() {
        return proto.getLastChange();
      }

      @Override
      Proto.Ref category() {
        return proto.getCategory();
      }

      @Override
      ProtocolStringList tags() {
        return proto.getTagsList();
      }

      @Override
      String library() {
        return proto.getLibrary();
      }
    };
  }
}
