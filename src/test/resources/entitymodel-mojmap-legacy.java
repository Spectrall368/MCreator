// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

public class CustomJavaModel extends EntityModel {
	private final RendererModel body;
	private final RendererModel head;
	private final RendererModel leg0;
	private final RendererModel leg1;
	private final RendererModel leg2;
	private final RendererModel leg3;

	public CustomJavaModel() {
		textureWidth = 64;
		textureHeight = 32;

		body = new RendererModel(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, -18.0F, -2.0F, 8, 12, 4, 0.0F, false));

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, 6.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));

		leg0 = new RendererModel(this);
		leg0.setRotationPoint(2.0F, 18.0F, 4.0F);
		leg0.cubeList.add(new ModelBox(leg0, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		leg1 = new RendererModel(this);
		leg1.setRotationPoint(-2.0F, 18.0F, 4.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		leg2 = new RendererModel(this);
		leg2.setRotationPoint(2.0F, 18.0F, -4.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));

		leg3 = new RendererModel(this);
		leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}