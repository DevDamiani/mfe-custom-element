package io.github.devdamiani.mfecustomelement.application;

import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.liferay.client.extension.model.ClientExtensionEntry;
import com.liferay.client.extension.service.ClientExtensionEntryService;
import com.liferay.client.extension.type.CET;
import com.liferay.client.extension.type.factory.CETFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Portal;

import io.github.devdamiani.mfecustomelement.dto.ClientExtensionEntryDTO;

/**
 * @author ddamiani
 */
@Component(
        property = {
            JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/mfecustomeelement",
            JaxrsWhiteboardConstants.JAX_RS_NAME + "=MfeCustomeElement.Rest"
        },
        service = Application.class
)
public class MfeCustomElementRestApiApplication extends Application {

    @Reference
    private ClientExtensionEntryService _clientExtensionEntryService;

    @Reference
    private CETFactory _cetFactory;

    @Reference
	private Portal _portal;

    private final Log logger;

    public MfeCustomElementRestApiApplication() {
        this.logger = LogFactoryUtil.getLog(MfeCustomElementRestApiApplication.class);
    }

    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ClientExtensionEntryDTO AddorUpdateCustomElement(@Context HttpServletRequest httpServletRequest, ClientExtensionEntryDTO clientExtensionEntryDTO) throws PortalException {

        logger.info("toUnicodeProperties.tostring:");
        logger.info(clientExtensionEntryDTO.getTypeSettings().toUnicodeProperties().toString());


        CET cet = _cetFactory.create(clientExtensionEntryDTO.toEntity(), false);

        ClientExtensionEntry fetchCX = _clientExtensionEntryService.
            fetchClientExtensionEntryByExternalReferenceCode(
                clientExtensionEntryDTO.getExternalReferenceCode(),
                _portal.getCompanyId(httpServletRequest)
            );

        if (fetchCX != null) {
            _clientExtensionEntryService.updateClientExtensionEntry(
                fetchCX.getClientExtensionEntryId(), 
                cet.getDescription(),
                clientExtensionEntryDTO.getName(),
                clientExtensionEntryDTO.getProperties(),
                cet.getSourceCodeURL(),
                cet.getTypeSettings()
            );

            return  clientExtensionEntryDTO;
        }

        _clientExtensionEntryService.addClientExtensionEntry(
                cet.getExternalReferenceCode(),
                cet.getDescription(),
                clientExtensionEntryDTO.getName(),
                clientExtensionEntryDTO.getProperties(),
                cet.getSourceCodeURL(),
                cet.getType(),
                cet.getTypeSettings()
        );

        return clientExtensionEntryDTO;
    }

}
