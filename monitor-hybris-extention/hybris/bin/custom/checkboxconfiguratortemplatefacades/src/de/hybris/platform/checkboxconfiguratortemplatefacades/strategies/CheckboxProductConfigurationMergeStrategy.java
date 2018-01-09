package de.hybris.platform.checkboxconfiguratortemplatefacades.strategies;

import de.hybris.platform.commercefacades.order.data.ConfigurationInfoData;
import de.hybris.platform.commercefacades.product.strategies.merge.ProductConfigurationMergeStrategy;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;


public class CheckboxProductConfigurationMergeStrategy implements ProductConfigurationMergeStrategy
{
	public static final String CHECKBOX_CHECKED_VALUE = "on";

	@Nonnull
	@Override
	public List<ConfigurationInfoData> merge(@Nonnull final List<ConfigurationInfoData> baseConfiguration,
			@Nonnull final List<ConfigurationInfoData> mergeConfiguration)
	{
		final List<String> formLabels = baseConfiguration.stream().peek(this::setConfigurationValueToBooleanString)
				.map(ConfigurationInfoData::getConfigurationLabel).collect(Collectors.toList());

		final List<ConfigurationInfoData> checkboxConfiguration = mergeConfiguration.stream()
				.filter(checkBoxConfiguration -> !formLabels.contains(checkBoxConfiguration.getConfigurationLabel()))
				.collect(Collectors.toList());

		checkboxConfiguration.stream().forEach(configuration -> configuration.setConfigurationValue(Boolean.FALSE.toString()));

		return checkboxConfiguration;
	}

	protected void setConfigurationValueToBooleanString(final ConfigurationInfoData configurationInfoData)
	{
		configurationInfoData.setConfigurationValue(
				Boolean.valueOf(CHECKBOX_CHECKED_VALUE.equals(configurationInfoData.getConfigurationValue())).toString());
	}
}