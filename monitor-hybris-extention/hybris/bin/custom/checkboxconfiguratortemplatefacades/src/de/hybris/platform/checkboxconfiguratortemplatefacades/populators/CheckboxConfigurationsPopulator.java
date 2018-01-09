package de.hybris.platform.checkboxconfiguratortemplatefacades.populators;

import de.hybris.platform.catalog.enums.ConfiguratorType;
import de.hybris.platform.checkboxconfiguratortemplateservices.model.CheckboxConfiguredProductInfoModel;
import de.hybris.platform.commercefacades.order.data.ConfigurationInfoData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.order.model.AbstractOrderEntryProductInfoModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.List;


/**
 * Populates configurations of type {@code CHECKBOX}.
 */
public class CheckboxConfigurationsPopulator<T extends AbstractOrderEntryProductInfoModel>
		implements Populator<T, List<ConfigurationInfoData>>
{
	@Override
	public void populate(final T source, final List<ConfigurationInfoData> target) throws ConversionException
	{
		if (source.getConfiguratorType() == ConfiguratorType.CHECKBOX)
		{
			if (!(source instanceof CheckboxConfiguredProductInfoModel))
			{
				throw new ConversionException(
						"Instance with type " + source.getConfiguratorType() + " is of class " + source.getClass().getName()
								+ " which is not convertible to " + CheckboxConfiguredProductInfoModel.class.getName());
			}
			final ConfigurationInfoData item = new ConfigurationInfoData();
			final CheckboxConfiguredProductInfoModel model = (CheckboxConfiguredProductInfoModel) source;
			item.setConfiguratorType(model.getConfiguratorType());
			item.setConfigurationLabel(model.getConfigurationLabel());
			item.setConfigurationValue(String.valueOf(model.isChecked()));
			item.setStatus(source.getProductInfoStatus());
			target.add(item);
		}
	}
}