package de.hybris.platform.checkboxconfiguratortemplateservices.order.hook;

import de.hybris.platform.catalog.enums.ConfiguratorType;
import de.hybris.platform.checkboxconfiguratortemplateservices.model.CheckboxConfiguratorSettingsModel;
import de.hybris.platform.checkboxconfiguratortemplateservices.model.CheckboxConfiguredProductInfoModel;
import de.hybris.platform.commerceservices.order.ProductConfigurationHandler;
import de.hybris.platform.commerceservices.service.data.ProductConfigurationItem;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.order.model.AbstractOrderEntryProductInfoModel;
import de.hybris.platform.product.model.AbstractConfiguratorSettingModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CheckboxConfigurationHandler implements ProductConfigurationHandler
{

	@Override
	public List<AbstractOrderEntryProductInfoModel> createProductInfo(final AbstractConfiguratorSettingModel productSettings)
	{
		if (!(productSettings instanceof CheckboxConfiguratorSettingsModel))
		{
			throw new IllegalArgumentException("Argument must be a type of CheckboxConfiguratorSettingsModel");
		}

		final CheckboxConfiguratorSettingsModel checkboxSettings = (CheckboxConfiguratorSettingsModel) productSettings;
		final CheckboxConfiguredProductInfoModel result = new CheckboxConfiguredProductInfoModel();
		result.setConfiguratorType(ConfiguratorType.CHECKBOX);
		result.setConfigurationLabel(checkboxSettings.getConfigurationLabel());
		result.setChecked(checkboxSettings.isChecked());
		return Collections.singletonList(result);
	}

	@Override
	public List<AbstractOrderEntryProductInfoModel> convert(final Collection<ProductConfigurationItem> items,
			final AbstractOrderEntryModel entry)
	{
		return items.stream().map(item -> {
			final CheckboxConfiguredProductInfoModel result = new CheckboxConfiguredProductInfoModel();
			result.setConfigurationLabel(item.getKey());
			result.setChecked(Boolean.valueOf(item.getValue().toString()));
			result.setConfiguratorType(ConfiguratorType.CHECKBOX);
			return result;
		}).collect(Collectors.toList());
	}
}