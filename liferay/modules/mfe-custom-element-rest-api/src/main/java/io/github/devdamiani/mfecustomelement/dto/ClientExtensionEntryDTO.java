package io.github.devdamiani.mfecustomelement.dto;

import java.util.Locale;
import java.util.Map;

import com.liferay.client.extension.model.ClientExtensionEntry;
import com.liferay.client.extension.service.ClientExtensionEntryLocalServiceUtil;

public class ClientExtensionEntryDTO {

    private String externalReferenceCode;
    private Map<Locale, String> name;
    private String sourceCodeURL;
    private TypeSettingsDTO typeSettings;
    private String description;
    private String type;
    private String properties;

    public String getExternalReferenceCode() {
        return externalReferenceCode;
    }

    public void setExternalReferenceCode(String externalReferenceCode) {
        this.externalReferenceCode = externalReferenceCode;
    }

    public Map<Locale, String> getName() {
        return name;
    }

    public void setName(Map<Locale, String> name) {
        this.name = name;
    }

    public String getSourceCodeURL() {
        return sourceCodeURL;
    }

    public void setSourceCodeURL(String sourceCodeURL) {
        this.sourceCodeURL = sourceCodeURL;
    }

    public TypeSettingsDTO getTypeSettings() {
        return typeSettings;
    }

    public void setTypeSettings(TypeSettingsDTO typeSettings) {
        this.typeSettings = typeSettings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public ClientExtensionEntry toEntity() {
        ClientExtensionEntry entry
                = ClientExtensionEntryLocalServiceUtil.createClientExtensionEntry(0);

        entry.setExternalReferenceCode(externalReferenceCode);
        entry.setDescription(description);
        entry.setProperties(properties);
        entry.setSourceCodeURL(sourceCodeURL);
        entry.setType(type);
        entry.setTypeSettings(typeSettings.toUnicodeProperties().toString());

        if (name != null && !name.isEmpty()) {
            entry.setNameMap(name);
        }

        return entry;
    }
}
