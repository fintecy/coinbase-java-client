package org.fintecy.md.coinbase.model.currencies;

import java.math.BigDecimal;
import java.util.Set;

public class CurrencyDetails {
    private final String type;
    private final String symbol;
    private final long networkConfirmations;
    private final long sortOrder;
    private final String cryptoAddressLink;
    private final String cryptoTransactionLink;
    private final Set<String> pushPaymentMethods;
    private final Set<String> groupTypes;
    private final String displayName;
    private final Long processingTimeSeconds;
    private final BigDecimal minWithdrawalAmount;
    private final BigDecimal maxWithdrawalAmount;

    public CurrencyDetails(String type, String symbol, long networkConfirmations, long sortOrder, String cryptoAddressLink, String cryptoTransactionLink, Set<String> pushPaymentMethods, Set<String> groupTypes, String displayName, Long processingTimeSeconds, BigDecimal minWithdrawalAmount, BigDecimal maxWithdrawalAmount) {
        this.type = type;
        this.symbol = symbol;
        this.networkConfirmations = networkConfirmations;
        this.sortOrder = sortOrder;
        this.cryptoAddressLink = cryptoAddressLink;
        this.cryptoTransactionLink = cryptoTransactionLink;
        this.pushPaymentMethods = pushPaymentMethods;
        this.groupTypes = groupTypes;
        this.displayName = displayName;
        this.processingTimeSeconds = processingTimeSeconds;
        this.minWithdrawalAmount = minWithdrawalAmount;
        this.maxWithdrawalAmount = maxWithdrawalAmount;
    }

    public static CurrencyDetailsBuilder builder() {
        return new CurrencyDetailsBuilder();
    }

    public String getType() {
        return this.type;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getNetworkConfirmations() {
        return this.networkConfirmations;
    }

    public long getSortOrder() {
        return this.sortOrder;
    }

    public String getCryptoAddressLink() {
        return this.cryptoAddressLink;
    }

    public String getCryptoTransactionLink() {
        return this.cryptoTransactionLink;
    }

    public Set<String> getPushPaymentMethods() {
        return this.pushPaymentMethods;
    }

    public Set<String> getGroupTypes() {
        return this.groupTypes;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Long getProcessingTimeSeconds() {
        return this.processingTimeSeconds;
    }

    public BigDecimal getMinWithdrawalAmount() {
        return this.minWithdrawalAmount;
    }

    public BigDecimal getMaxWithdrawalAmount() {
        return this.maxWithdrawalAmount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CurrencyDetails)) return false;
        final CurrencyDetails other = (CurrencyDetails) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$symbol = this.getSymbol();
        final Object other$symbol = other.getSymbol();
        if (this$symbol == null ? other$symbol != null : !this$symbol.equals(other$symbol)) return false;
        if (this.getNetworkConfirmations() != other.getNetworkConfirmations()) return false;
        if (this.getSortOrder() != other.getSortOrder()) return false;
        final Object this$cryptoAddressLink = this.getCryptoAddressLink();
        final Object other$cryptoAddressLink = other.getCryptoAddressLink();
        if (this$cryptoAddressLink == null ? other$cryptoAddressLink != null : !this$cryptoAddressLink.equals(other$cryptoAddressLink))
            return false;
        final Object this$cryptoTransactionLink = this.getCryptoTransactionLink();
        final Object other$cryptoTransactionLink = other.getCryptoTransactionLink();
        if (this$cryptoTransactionLink == null ? other$cryptoTransactionLink != null : !this$cryptoTransactionLink.equals(other$cryptoTransactionLink))
            return false;
        final Object this$pushPaymentMethods = this.getPushPaymentMethods();
        final Object other$pushPaymentMethods = other.getPushPaymentMethods();
        if (this$pushPaymentMethods == null ? other$pushPaymentMethods != null : !this$pushPaymentMethods.equals(other$pushPaymentMethods))
            return false;
        final Object this$groupTypes = this.getGroupTypes();
        final Object other$groupTypes = other.getGroupTypes();
        if (this$groupTypes == null ? other$groupTypes != null : !this$groupTypes.equals(other$groupTypes))
            return false;
        final Object this$displayName = this.getDisplayName();
        final Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName))
            return false;
        final Object this$processingTimeSeconds = this.getProcessingTimeSeconds();
        final Object other$processingTimeSeconds = other.getProcessingTimeSeconds();
        if (this$processingTimeSeconds == null ? other$processingTimeSeconds != null : !this$processingTimeSeconds.equals(other$processingTimeSeconds))
            return false;
        final Object this$minWithdrawalAmount = this.getMinWithdrawalAmount();
        final Object other$minWithdrawalAmount = other.getMinWithdrawalAmount();
        if (this$minWithdrawalAmount == null ? other$minWithdrawalAmount != null : !this$minWithdrawalAmount.equals(other$minWithdrawalAmount))
            return false;
        final Object this$maxWithdrawalAmount = this.getMaxWithdrawalAmount();
        final Object other$maxWithdrawalAmount = other.getMaxWithdrawalAmount();
        if (this$maxWithdrawalAmount == null ? other$maxWithdrawalAmount != null : !this$maxWithdrawalAmount.equals(other$maxWithdrawalAmount))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CurrencyDetails;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $symbol = this.getSymbol();
        result = result * PRIME + ($symbol == null ? 43 : $symbol.hashCode());
        final long $networkConfirmations = this.getNetworkConfirmations();
        result = result * PRIME + (int) ($networkConfirmations >>> 32 ^ $networkConfirmations);
        final long $sortOrder = this.getSortOrder();
        result = result * PRIME + (int) ($sortOrder >>> 32 ^ $sortOrder);
        final Object $cryptoAddressLink = this.getCryptoAddressLink();
        result = result * PRIME + ($cryptoAddressLink == null ? 43 : $cryptoAddressLink.hashCode());
        final Object $cryptoTransactionLink = this.getCryptoTransactionLink();
        result = result * PRIME + ($cryptoTransactionLink == null ? 43 : $cryptoTransactionLink.hashCode());
        final Object $pushPaymentMethods = this.getPushPaymentMethods();
        result = result * PRIME + ($pushPaymentMethods == null ? 43 : $pushPaymentMethods.hashCode());
        final Object $groupTypes = this.getGroupTypes();
        result = result * PRIME + ($groupTypes == null ? 43 : $groupTypes.hashCode());
        final Object $displayName = this.getDisplayName();
        result = result * PRIME + ($displayName == null ? 43 : $displayName.hashCode());
        final Object $processingTimeSeconds = this.getProcessingTimeSeconds();
        result = result * PRIME + ($processingTimeSeconds == null ? 43 : $processingTimeSeconds.hashCode());
        final Object $minWithdrawalAmount = this.getMinWithdrawalAmount();
        result = result * PRIME + ($minWithdrawalAmount == null ? 43 : $minWithdrawalAmount.hashCode());
        final Object $maxWithdrawalAmount = this.getMaxWithdrawalAmount();
        result = result * PRIME + ($maxWithdrawalAmount == null ? 43 : $maxWithdrawalAmount.hashCode());
        return result;
    }

    public String toString() {
        return "CurrencyDetails(type=" + this.getType() + ", symbol=" + this.getSymbol() + ", networkConfirmations=" + this.getNetworkConfirmations() + ", sortOrder=" + this.getSortOrder() + ", cryptoAddressLink=" + this.getCryptoAddressLink() + ", cryptoTransactionLink=" + this.getCryptoTransactionLink() + ", pushPaymentMethods=" + this.getPushPaymentMethods() + ", groupTypes=" + this.getGroupTypes() + ", displayName=" + this.getDisplayName() + ", processingTimeSeconds=" + this.getProcessingTimeSeconds() + ", minWithdrawalAmount=" + this.getMinWithdrawalAmount() + ", maxWithdrawalAmount=" + this.getMaxWithdrawalAmount() + ")";
    }

    public static class CurrencyDetailsBuilder {
        private String type;
        private String symbol;
        private long networkConfirmations;
        private long sortOrder;
        private String cryptoAddressLink;
        private String cryptoTransactionLink;
        private Set<String> pushPaymentMethods;
        private Set<String> groupTypes;
        private String displayName;
        private Long processingTimeSeconds;
        private BigDecimal minWithdrawalAmount;
        private BigDecimal maxWithdrawalAmount;

        CurrencyDetailsBuilder() {
        }

        public CurrencyDetailsBuilder type(String type) {
            this.type = type;
            return this;
        }

        public CurrencyDetailsBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public CurrencyDetailsBuilder networkConfirmations(long networkConfirmations) {
            this.networkConfirmations = networkConfirmations;
            return this;
        }

        public CurrencyDetailsBuilder sortOrder(long sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public CurrencyDetailsBuilder cryptoAddressLink(String cryptoAddressLink) {
            this.cryptoAddressLink = cryptoAddressLink;
            return this;
        }

        public CurrencyDetailsBuilder cryptoTransactionLink(String cryptoTransactionLink) {
            this.cryptoTransactionLink = cryptoTransactionLink;
            return this;
        }

        public CurrencyDetailsBuilder pushPaymentMethods(Set<String> pushPaymentMethods) {
            this.pushPaymentMethods = pushPaymentMethods;
            return this;
        }

        public CurrencyDetailsBuilder groupTypes(Set<String> groupTypes) {
            this.groupTypes = groupTypes;
            return this;
        }

        public CurrencyDetailsBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public CurrencyDetailsBuilder processingTimeSeconds(Long processingTimeSeconds) {
            this.processingTimeSeconds = processingTimeSeconds;
            return this;
        }

        public CurrencyDetailsBuilder minWithdrawalAmount(BigDecimal minWithdrawalAmount) {
            this.minWithdrawalAmount = minWithdrawalAmount;
            return this;
        }

        public CurrencyDetailsBuilder maxWithdrawalAmount(BigDecimal maxWithdrawalAmount) {
            this.maxWithdrawalAmount = maxWithdrawalAmount;
            return this;
        }

        public CurrencyDetails build() {
            return new CurrencyDetails(type, symbol, networkConfirmations, sortOrder, cryptoAddressLink, cryptoTransactionLink, pushPaymentMethods, groupTypes, displayName, processingTimeSeconds, minWithdrawalAmount, maxWithdrawalAmount);
        }

        public String toString() {
            return "CurrencyDetails.CurrencyDetailsBuilder(type=" + this.type + ", symbol=" + this.symbol + ", networkConfirmations=" + this.networkConfirmations + ", sortOrder=" + this.sortOrder + ", cryptoAddressLink=" + this.cryptoAddressLink + ", cryptoTransactionLink=" + this.cryptoTransactionLink + ", pushPaymentMethods=" + this.pushPaymentMethods + ", groupTypes=" + this.groupTypes + ", displayName=" + this.displayName + ", processingTimeSeconds=" + this.processingTimeSeconds + ", minWithdrawalAmount=" + this.minWithdrawalAmount + ", maxWithdrawalAmount=" + this.maxWithdrawalAmount + ")";
        }
    }
}
