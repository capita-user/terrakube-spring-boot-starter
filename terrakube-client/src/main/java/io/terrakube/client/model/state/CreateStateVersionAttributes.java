package io.terrakube.client.model.state;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStateVersionAttributes {
    String state;
    @SerializedName("json-state")
    String jsonState;
}