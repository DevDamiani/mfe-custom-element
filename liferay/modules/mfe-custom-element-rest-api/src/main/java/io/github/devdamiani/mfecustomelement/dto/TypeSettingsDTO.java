package io.github.devdamiani.mfecustomelement.dto;

import java.util.List;

import com.liferay.petra.string.StringPool;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.UnicodePropertiesBuilder;

public class TypeSettingsDTO {

    private String htmlElementName;
    private boolean instanceable;
    private String portletCategoryName;
    private List<String> urls;
    private List<String> cssURLs;

    private boolean useESM;

    public String getHtmlElementName() {
        return htmlElementName;
    }

    public void setHtmlElementName(String htmlElementName) {
        this.htmlElementName = htmlElementName;
    }

    public boolean isInstanceable() {
        return instanceable;
    }

    public void setInstanceable(boolean instanceable) {
        this.instanceable = instanceable;
    }

    public String getPortletCategoryName() {
        return portletCategoryName;
    }

    public void setPortletCategoryName(String portletCategoryName) {
        this.portletCategoryName = portletCategoryName;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public boolean isUseESM() {
        return useESM;
    }

    public void setUseESM(boolean useESM) {
        this.useESM = useESM;
    }

    public List<String> getCssURLs() {
        return cssURLs;
    }

    public void setCssURLs(List<String> cssURLs) {
        this.cssURLs = cssURLs;
    }

    public UnicodeProperties toUnicodeProperties() {

		return UnicodePropertiesBuilder.create(
			true
		).put(
			"cssURLs",
			StringUtil.merge(
				getCssURLs(),
				StringPool.RETURN_NEW_LINE)
		).put(
			"htmlElementName",
			getHtmlElementName()
		).put(
			"instanceable", isInstanceable()
		).put(
			"portletCategoryName",
			getPortletCategoryName()
		).put(
			"urls",
			StringUtil.merge(
				getUrls(),
				StringPool.RETURN_NEW_LINE)
		).put(
			"useESM", isUseESM()
		).build();

    }
}
