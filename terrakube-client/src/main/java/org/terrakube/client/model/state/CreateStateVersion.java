package org.terrakube.client.model.state;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStateVersion {
    String type = "state-versions";
    CreateStateVersionAttributes attributes;
    CreateStateVersionRelationships relationships;
}
