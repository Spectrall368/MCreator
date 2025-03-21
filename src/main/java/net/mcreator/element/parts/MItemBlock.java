/*
 * MCreator (https://mcreator.net/)
 * Copyright (C) 2020 Pylo and contributors
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

package net.mcreator.element.parts;

import net.mcreator.generator.mapping.MappableElement;
import net.mcreator.generator.mapping.NameMapper;
import net.mcreator.workspace.Workspace;

import javax.annotation.Nonnull;

public class MItemBlock extends MappableElement {

	private MItemBlock() {
		super(new NameMapper(null, "blocksitems"));
	}

	public MItemBlock(@Nonnull Workspace owner, String name) {
		super(new NameMapper(owner, "blocksitems"), name);
	}

	public boolean isAir() {
		String unmappedValue = getUnmappedValue();
		return unmappedValue.equals("Blocks.AIR") || unmappedValue.equals("Blocks.VOID_AIR") || unmappedValue.equals(
				"Blocks.CAVE_AIR");
	}

}
