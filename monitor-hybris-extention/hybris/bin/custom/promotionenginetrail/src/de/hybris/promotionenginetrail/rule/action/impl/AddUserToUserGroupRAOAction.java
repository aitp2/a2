package de.hybris.promotionenginetrail.rule.action.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static de.hybris.platform.ruleengineservices.util.RAOConstants.VALUE_PARAM;
import static org.apache.commons.collections.MapUtils.isNotEmpty;

import de.hybris.platform.ruleengineservices.rao.CartRAO;
import de.hybris.platform.ruleengineservices.rao.ChangeUserGroupRAO;
import de.hybris.platform.ruleengineservices.rao.RuleEngineResultRAO;
import de.hybris.platform.ruleengineservices.rao.UserGroupRAO;
import de.hybris.platform.ruleengineservices.rao.UserRAO;
import de.hybris.platform.ruleengineservices.rule.evaluation.RuleActionContext;
import de.hybris.platform.ruleengineservices.rule.evaluation.actions.AbstractRuleExecutableSupport;
import de.hybris.platform.ruleengineservices.rule.evaluation.actions.RAOAction;

import java.util.Map;


public class AddUserToUserGroupRAOAction extends AbstractRuleExecutableSupport implements RAOAction
{
	@Override
	public void performAction(final RuleActionContext context, final Map<String, Object> parameters)
	{
		checkArgument(isNotEmpty(parameters), "Properties passed as a method argument must not be empty");
		validateRule(context);

		performAction(context, (String) parameters.get(VALUE_PARAM));

		trackRuleGroupExecutions(context);
		trackRuleExecution(context);
	}

	protected void performAction(final RuleActionContext context, final String userGroupCode)
	{
		final CartRAO cartRao = context.getCartRao();
		final RuleEngineResultRAO result = context.getRuleEngineResultRao();

		final ChangeUserGroupRAO changeUserGroupRAO = new ChangeUserGroupRAO();
		getRaoUtils().addAction(cartRao, changeUserGroupRAO);
		changeUserGroupRAO.setUserGroupId(userGroupCode);
		result.getActions().add(changeUserGroupRAO);

		final UserGroupRAO userGroupRAO = new UserGroupRAO();
		userGroupRAO.setId(userGroupCode);
		final UserRAO user = cartRao.getUser();
		user.getGroups().add(userGroupRAO);

		setRAOMetaData(context, changeUserGroupRAO);
		context.insertFacts(context, changeUserGroupRAO, userGroupRAO);
		context.updateFacts(context, user);
	}
}