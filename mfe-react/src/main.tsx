import { createRoot, type Root } from "react-dom/client";
import App from "./App.tsx";

class ReactWebComponent extends HTMLElement {
  private root: Root | null = null;

  connectedCallback() {
    if (!this.root) {
      this.root = createRoot(this);
    }

    const props: Record<string, any> = {};
    for (const attr of this.getAttributeNames()) {
      props[attr] = this.getAttribute(attr);
    }

    this.root.render(<App {...props} />);
  }

  disconnectedCallback() {
    this.root?.unmount();
  }
}

customElements.define("mfe-react", ReactWebComponent);
