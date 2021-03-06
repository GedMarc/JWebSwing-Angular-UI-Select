/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.angularuiselect;

import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.plugins.angularuiselect.interfaces.AngularUISelectChildren;

import java.util.Objects;

/**
 * Angular UI Sortable Helper
 *
 * @author GedMarc
 * @since 09 Jun 2017
 */
@ComponentInformation(name = "Angular UI Select",
		description = "A native AngularJS implementation of Select2/Selectize by the AngularUI Team",
		url = "https://angular-ui.github.io/ui-select")
public class AngularUISelect
		extends Div<AngularUISelectChildren, AngularUISelectAttributes, GlobalFeatures, GlobalEvents, AngularUISelect>
{


	/**
	 * The current selected match item display
	 */
	private AngularUISelectMatch selected;
	/**
	 * The children for the selector display
	 */
	private AngularUISelectChoices availableChoices;

	/*
	 * Constructs a new AngularUISelect
	 */
	public AngularUISelect(String variableName, String placeHolder, String itemRepeatString, String componentDisplay)
	{
		setTag("ui-select");
		selected = new AngularUISelectMatch(variableName, placeHolder);
		availableChoices = new AngularUISelectChoices(itemRepeatString, componentDisplay);

		add(selected);
		add(availableChoices);
	}

	/**
	 * Closes a multi-select upon selection
	 *
	 * @param closeOnSelect
	 *
	 * @return
	 */
	public AngularUISelect setCloseOnSelect(boolean closeOnSelect)
	{
		addAttribute(AngularUISelectAttributes.Close_On_Select, closeOnSelect);
		return this;
	}

	/**
	 * Appends the dropdown to the box vs relative
	 *
	 * @param appendToBody
	 *
	 * @return
	 */
	public AngularUISelect setAppendToBody(boolean appendToBody)
	{
		addAttribute(AngularUISelectAttributes.Append_To_Body, appendToBody);
		return this;
	}

	/**
	 * Control is disabled
	 *
	 * @param disabled
	 *
	 * @return
	 */
	public AngularUISelect setDisabled(boolean disabled)
	{
		addAttribute(AngularUISelectAttributes.Disabled, disabled);
		return this;
	}

	/**
	 * Result is bound to variable
	 *
	 * @param variableName
	 *
	 * @return
	 */
	public AngularUISelect setModel(String variableName)
	{
		bind(variableName);
		return this;
	}

	/**
	 * Search is enabled
	 *
	 * @param searchEnabled
	 *
	 * @return
	 */
	public AngularUISelect setSearchEnabled(boolean searchEnabled)
	{
		addAttribute(AngularUISelectAttributes.Search_Enabled, searchEnabled);
		return this;
	}

	/**
	 * Clears the search box after selecting an option
	 *
	 * @param resetSearchInput
	 *
	 * @return
	 */
	public AngularUISelect setResetSearchInput(boolean resetSearchInput)
	{
		addAttribute(AngularUISelectAttributes.Reset_Search_Input, resetSearchInput);
		return this;
	}

	/**
	 * Sets the specified theme
	 *
	 * @param theme
	 *
	 * @return
	 */
	public AngularUISelect setTheme(AngularUISelectTheme theme)
	{
		addAttribute(AngularUISelectAttributes.Theme, theme.toString());
		return this;
	}

	/**
	 * Enable tagging mode (add new items on the fly). Accepts a string which is a scope function. If your model is an array of objects, this string is required. The function will
	 * be passed the new
	 * item as a string and should return an object which is the transformed value to be pushed to the items array.
	 *
	 * @param tagging
	 *
	 * @return
	 */
	public AngularUISelect setTagging(String tagging)
	{
		addAttribute(AngularUISelectAttributes.Tagging, tagging);
		return this;
	}

	/**
	 * Set a label for tags that appear in the dropdown. Expects a string or  FALSE . If  FALSE , then tagging happens without new items appearing in the dropdown. If empty or
	 * undeclared, 
	 * tagging-label defaults to  (new)
	 *
	 * @param tagglingLabel
	 *
	 * @return
	 */
	public AngularUISelect setTaggingLabel(String tagglingLabel)
	{
		addAttribute(AngularUISelectAttributes.Tagging_Label, tagglingLabel);
		return this;
	}

	/**
	 * Specify keyboard keys that will trigger creation of a new tag. Multiple keys can be separated by a pipe `
	 *
	 * @param taggingTokens
	 *
	 * @return
	 */
	public AngularUISelect setTaggingTokens(String taggingTokens)
	{
		addAttribute(AngularUISelectAttributes.Tagging_Tokens, taggingTokens);
		return this;
	}

	/**
	 * Automatically get focus when loaded.
	 *
	 * @param autoFocus
	 *
	 * @return
	 */
	public AngularUISelect setAutoFocus(boolean autoFocus)
	{
		addAttribute(AngularUISelectAttributes.AutoFocus, autoFocus);
		return this;
	}

	/**
	 * Set to true to skip the focusser after selecting an item.
	 *
	 * @param skipFocusser
	 *
	 * @return
	 */
	public AngularUISelect setSkipFocusser(boolean skipFocusser)
	{
		addAttribute(AngularUISelectAttributes.Skip_Focusser, skipFocusser);
		return this;
	}

	/**
	 * Accepts a string which is a scope function. The function will be passed the pasted text as a string.
	 *
	 * @param closeOnSelect
	 *
	 * @return
	 */
	public AngularUISelect setPaste(String closeOnSelect)
	{
		addAttribute(AngularUISelectAttributes.Paste, closeOnSelect);
		return this;
	}

	/**
	 * Limits the number of selected items in multiple select mode
	 *
	 * @param closeOnSelect
	 *
	 * @return
	 */
	public AngularUISelect setLimit(Integer closeOnSelect)
	{
		addAttribute(AngularUISelectAttributes.Limit, closeOnSelect);
		return this;
	}

	/**
	 * Sets the spinner enabled when using the refresh function
	 *
	 * @param spinnerEnabled
	 *
	 * @return
	 */
	public AngularUISelect setSpinnerEnabled(boolean spinnerEnabled)
	{
		addAttribute(AngularUISelectAttributes.Spinner_Enabled, spinnerEnabled);
		return this;
	}

	/**
	 * Sets the spinner css class. Default it will have its own style but can be overridden using this.
	 *
	 * @param spinnerClass
	 *
	 * @return
	 */
	public AngularUISelect setSpinnerClass(String spinnerClass)
	{
		addAttribute(AngularUISelectAttributes.Spinner_Class, spinnerClass);
		return this;
	}

	/**
	 * Sets the input  id  so it can be labelled
	 *
	 * @param inputId
	 *
	 * @return
	 */
	public AngularUISelect setInputId(String inputId)
	{
		addAttribute(AngularUISelectAttributes.Input_Id, inputId);
		return this;
	}

	/**
	 * Sets the title for the select drop down
	 *
	 * @param title
	 *
	 * @return
	 */
	public AngularUISelect setTitle(String title)
	{
		addAttribute(GlobalAttributes.Title, title);
		return this;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.hashCode(), selected, availableChoices);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof AngularUISelect))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}
		AngularUISelect that = (AngularUISelect) o;
		return Objects.equals(selected, that.selected) && Objects.equals(availableChoices, that.availableChoices);
	}
}
