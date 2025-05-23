/*
 * MCreator (https://mcreator.net/)
 * Copyright (C) 2012-2020, Pylo
 * Copyright (C) 2020-2025, Pylo, opensource contributors
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

package net.mcreator.blockly.java.blocks;

import net.mcreator.blockly.BlocklyCompileNote;
import net.mcreator.blockly.BlocklyToCode;
import net.mcreator.blockly.IBlockGenerator;
import net.mcreator.blockly.java.ProcedureCodeOptimizer;
import net.mcreator.generator.template.TemplateGeneratorException;
import net.mcreator.ui.init.L10N;
import net.mcreator.util.XMLUtil;
import org.w3c.dom.Element;

public class NullComparisonBlock implements IBlockGenerator {

	@Override public void generateBlock(BlocklyToCode master, Element block) throws TemplateGeneratorException {
		Element toCompare = XMLUtil.getFirstChildrenWithName(block, "value");
		Element operation = XMLUtil.getFirstChildrenWithName(block, "field");
		if (toCompare != null && operation != null) {
			// If possible, remove parentheses from the input
			String inputCode = ProcedureCodeOptimizer.removeParentheses(
					BlocklyToCode.directProcessOutputBlock(master, toCompare), "=^&|?");
			master.append("(");
			master.append(inputCode).append(operation.getTextContent()).append("null");
			master.append(")");
		} else {
			master.append("false");
			master.addCompileNote(new BlocklyCompileNote(BlocklyCompileNote.Type.WARNING,
					L10N.t("blockly.warnings.empty_null_comparison")));
		}
	}

	@Override public String[] getSupportedBlocks() {
		return new String[] { "logic_null_comparison" };
	}

	@Override public BlockType getBlockType() {
		return BlockType.OUTPUT;
	}

}
