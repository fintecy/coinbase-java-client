package org.fintecy.md.coinbase.model;

public class CryptoNetwork {
    private final String id;
    private final String name;
    private final String status;
    private final String contractAddress;
    private final String cryptoAddressLink;
    private final String cryptoTransactionLink;
    private final String minWithdrawalAmount;
    private final String maxWithdrawalAmount;
    private final String networkConfirmations;
    private final String processingTimeSeconds;

    CryptoNetwork(String id, String name, String status, String contractAddress, String cryptoAddressLink, String cryptoTransactionLink, String minWithdrawalAmount, String maxWithdrawalAmount, String networkConfirmations, String processingTimeSeconds) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.contractAddress = contractAddress;
        this.cryptoAddressLink = cryptoAddressLink;
        this.cryptoTransactionLink = cryptoTransactionLink;
        this.minWithdrawalAmount = minWithdrawalAmount;
        this.maxWithdrawalAmount = maxWithdrawalAmount;
        this.networkConfirmations = networkConfirmations;
        this.processingTimeSeconds = processingTimeSeconds;
    }

    public static CryptoNetworkBuilder builder() {
        return new CryptoNetworkBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public String getContractAddress() {
        return this.contractAddress;
    }

    public String getCryptoAddressLink() {
        return this.cryptoAddressLink;
    }

    public String getCryptoTransactionLink() {
        return this.cryptoTransactionLink;
    }

    public String getMinWithdrawalAmount() {
        return this.minWithdrawalAmount;
    }

    public String getMaxWithdrawalAmount() {
        return this.maxWithdrawalAmount;
    }

    public String getNetworkConfirmations() {
        return this.networkConfirmations;
    }

    public String getProcessingTimeSeconds() {
        return this.processingTimeSeconds;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CryptoNetwork)) return false;
        final CryptoNetwork other = (CryptoNetwork) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$contractAddress = this.getContractAddress();
        final Object other$contractAddress = other.getContractAddress();
        if (this$contractAddress == null ? other$contractAddress != null : !this$contractAddress.equals(other$contractAddress))
            return false;
        final Object this$cryptoAddressLink = this.getCryptoAddressLink();
        final Object other$cryptoAddressLink = other.getCryptoAddressLink();
        if (this$cryptoAddressLink == null ? other$cryptoAddressLink != null : !this$cryptoAddressLink.equals(other$cryptoAddressLink))
            return false;
        final Object this$cryptoTransactionLink = this.getCryptoTransactionLink();
        final Object other$cryptoTransactionLink = other.getCryptoTransactionLink();
        if (this$cryptoTransactionLink == null ? other$cryptoTransactionLink != null : !this$cryptoTransactionLink.equals(other$cryptoTransactionLink))
            return false;
        final Object this$minWithdrawalAmount = this.getMinWithdrawalAmount();
        final Object other$minWithdrawalAmount = other.getMinWithdrawalAmount();
        if (this$minWithdrawalAmount == null ? other$minWithdrawalAmount != null : !this$minWithdrawalAmount.equals(other$minWithdrawalAmount))
            return false;
        final Object this$maxWithdrawalAmount = this.getMaxWithdrawalAmount();
        final Object other$maxWithdrawalAmount = other.getMaxWithdrawalAmount();
        if (this$maxWithdrawalAmount == null ? other$maxWithdrawalAmount != null : !this$maxWithdrawalAmount.equals(other$maxWithdrawalAmount))
            return false;
        final Object this$networkConfirmations = this.getNetworkConfirmations();
        final Object other$networkConfirmations = other.getNetworkConfirmations();
        if (this$networkConfirmations == null ? other$networkConfirmations != null : !this$networkConfirmations.equals(other$networkConfirmations))
            return false;
        final Object this$processingTimeSeconds = this.getProcessingTimeSeconds();
        final Object other$processingTimeSeconds = other.getProcessingTimeSeconds();
        if (this$processingTimeSeconds == null ? other$processingTimeSeconds != null : !this$processingTimeSeconds.equals(other$processingTimeSeconds))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CryptoNetwork;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $contractAddress = this.getContractAddress();
        result = result * PRIME + ($contractAddress == null ? 43 : $contractAddress.hashCode());
        final Object $cryptoAddressLink = this.getCryptoAddressLink();
        result = result * PRIME + ($cryptoAddressLink == null ? 43 : $cryptoAddressLink.hashCode());
        final Object $cryptoTransactionLink = this.getCryptoTransactionLink();
        result = result * PRIME + ($cryptoTransactionLink == null ? 43 : $cryptoTransactionLink.hashCode());
        final Object $minWithdrawalAmount = this.getMinWithdrawalAmount();
        result = result * PRIME + ($minWithdrawalAmount == null ? 43 : $minWithdrawalAmount.hashCode());
        final Object $maxWithdrawalAmount = this.getMaxWithdrawalAmount();
        result = result * PRIME + ($maxWithdrawalAmount == null ? 43 : $maxWithdrawalAmount.hashCode());
        final Object $networkConfirmations = this.getNetworkConfirmations();
        result = result * PRIME + ($networkConfirmations == null ? 43 : $networkConfirmations.hashCode());
        final Object $processingTimeSeconds = this.getProcessingTimeSeconds();
        result = result * PRIME + ($processingTimeSeconds == null ? 43 : $processingTimeSeconds.hashCode());
        return result;
    }

    public String toString() {
        return "CryptoNetwork(id=" + this.getId() + ", name=" + this.getName() + ", status=" + this.getStatus() + ", contractAddress=" + this.getContractAddress() + ", cryptoAddressLink=" + this.getCryptoAddressLink() + ", cryptoTransactionLink=" + this.getCryptoTransactionLink() + ", minWithdrawalAmount=" + this.getMinWithdrawalAmount() + ", maxWithdrawalAmount=" + this.getMaxWithdrawalAmount() + ", networkConfirmations=" + this.getNetworkConfirmations() + ", processingTimeSeconds=" + this.getProcessingTimeSeconds() + ")";
    }

    public static class CryptoNetworkBuilder {
        private String id;
        private String name;
        private String status;
        private String contractAddress;
        private String cryptoAddressLink;
        private String cryptoTransactionLink;
        private String minWithdrawalAmount;
        private String maxWithdrawalAmount;
        private String networkConfirmations;
        private String processingTimeSeconds;

        CryptoNetworkBuilder() {
        }

        public CryptoNetworkBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CryptoNetworkBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CryptoNetworkBuilder status(String status) {
            this.status = status;
            return this;
        }

        public CryptoNetworkBuilder contractAddress(String contractAddress) {
            this.contractAddress = contractAddress;
            return this;
        }

        public CryptoNetworkBuilder cryptoAddressLink(String cryptoAddressLink) {
            this.cryptoAddressLink = cryptoAddressLink;
            return this;
        }

        public CryptoNetworkBuilder cryptoTransactionLink(String cryptoTransactionLink) {
            this.cryptoTransactionLink = cryptoTransactionLink;
            return this;
        }

        public CryptoNetworkBuilder minWithdrawalAmount(String minWithdrawalAmount) {
            this.minWithdrawalAmount = minWithdrawalAmount;
            return this;
        }

        public CryptoNetworkBuilder maxWithdrawalAmount(String maxWithdrawalAmount) {
            this.maxWithdrawalAmount = maxWithdrawalAmount;
            return this;
        }

        public CryptoNetworkBuilder networkConfirmations(String networkConfirmations) {
            this.networkConfirmations = networkConfirmations;
            return this;
        }

        public CryptoNetworkBuilder processingTimeSeconds(String processingTimeSeconds) {
            this.processingTimeSeconds = processingTimeSeconds;
            return this;
        }

        public CryptoNetwork build() {
            return new CryptoNetwork(id, name, status, contractAddress, cryptoAddressLink, cryptoTransactionLink, minWithdrawalAmount, maxWithdrawalAmount, networkConfirmations, processingTimeSeconds);
        }

        public String toString() {
            return "CryptoNetwork.CryptoNetworkBuilder(id=" + this.id + ", name=" + this.name + ", status=" + this.status + ", contractAddress=" + this.contractAddress + ", cryptoAddressLink=" + this.cryptoAddressLink + ", cryptoTransactionLink=" + this.cryptoTransactionLink + ", minWithdrawalAmount=" + this.minWithdrawalAmount + ", maxWithdrawalAmount=" + this.maxWithdrawalAmount + ", networkConfirmations=" + this.networkConfirmations + ", processingTimeSeconds=" + this.processingTimeSeconds + ")";
        }
    }
}
