/*
 * MCreator (https://mcreator.net/)
 * Copyright (C) 2012-2020, Pylo
 * Copyright (C) 2020-2026, Pylo, opensource contributors
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.mcreator.ui.minecraft.mapping;

import net.mcreator.ui.component.entries.JSimpleListEntry;
import net.mcreator.ui.help.HelpUtils;
import net.mcreator.ui.help.IHelpContext;
import net.mcreator.ui.init.L10N;
import net.mcreator.ui.validation.component.VTextField;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JMappingEntry extends JSimpleListEntry<Mapping> {

	private final VTextField from = new VTextField(15).requireValue(
			"elementgui.villager_profession.profession_needs_display_name").enableRealtimeValidation();
	private final VTextField to = new VTextField(15).requireValue(
			"elementgui.villager_profession.profession_needs_display_name").enableRealtimeValidation();
	private final JComboBox<String> registry = new JComboBox<>(new String[] { "BLOCK", "ITEM" });

	public JMappingEntry(IHelpContext gui, JPanel parent, List<JMappingEntry> entryList) {
		super(parent, entryList);

		line.add(HelpUtils.wrapWithHelpButton(gui.withEntry("villagerprofession/display_name"), L10N.label("Old id")));
		line.add(from);
		line.add(HelpUtils.wrapWithHelpButton(gui.withEntry("villagerprofession/display_name"), L10N.label("New id")));
		line.add(to);

		JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		line2.setOpaque(false);

		line2.add(HelpUtils.wrapWithHelpButton(gui.withEntry("item/rarity"), L10N.label("elementgui.common.rarity")));
		line2.add(registry);

		add(line);
		add(line2);
	}

	@Override protected void setEntryEnabled(boolean enabled) {
		from.setEnabled(enabled);
		to.setEnabled(enabled);
		registry.setEnabled(enabled);
	}

	@Override public Mapping getEntry() {
		return new Mapping(from.getText(), to.getText(), registry.getSelectedItem().toString());
	}

	@Override public void setEntry(Mapping entry) {
		from.setText(entry.from);
		to.setText(entry.to);
		registry.setSelectedItem(entry.registry);
	}
}