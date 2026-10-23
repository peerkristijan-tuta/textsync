import { buildModule } from "@nomicfoundation/hardhat-ignition/modules";

export default buildModule("TextRegistry", (m) => {
    const registry = m.contract("TextRegistry");
    return { registry };
});