package org.fintecy.md.coinbase.model;

public class Product {
    private final String id;
    private final String baseCurrency;
    private final String quoteCurrency;
    private final String quoteIncrement;
    private final String baseIncrement;
    private final String displayName;
    private final String minMarketFunds;
    private final String marginEnabled;
    private final String postOnly;
    private final String limitOnly;
    private final String cancelOnly;
    private final String status;
    private final String statusMessage;
    private final String tradingDisabled;
    private final String fxStablecoin;
    private final String maxSlippagePercentage;
    private final String auctionMode;

    Product(String id, String baseCurrency, String quoteCurrency, String quoteIncrement, String baseIncrement,
            String displayName, String minMarketFunds, String marginEnabled, String postOnly, String limitOnly,
            String cancelOnly, String status, String statusMessage, String tradingDisabled, String fxStablecoin,
            String maxSlippagePercentage, String auctionMode) {
        this.id = id;
        this.baseCurrency = baseCurrency;
        this.quoteCurrency = quoteCurrency;
        this.quoteIncrement = quoteIncrement;
        this.baseIncrement = baseIncrement;
        this.displayName = displayName;
        this.minMarketFunds = minMarketFunds;
        this.marginEnabled = marginEnabled;
        this.postOnly = postOnly;
        this.limitOnly = limitOnly;
        this.cancelOnly = cancelOnly;
        this.status = status;
        this.statusMessage = statusMessage;
        this.tradingDisabled = tradingDisabled;
        this.fxStablecoin = fxStablecoin;
        this.maxSlippagePercentage = maxSlippagePercentage;
        this.auctionMode = auctionMode;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static Product product(String id, String base, String counter, String status) {
        return builder().id(id).baseCurrency(base).quoteCurrency(counter).status(status).build();
    }

    public String getId() {
        return this.id;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteIncrement() {
        return this.quoteIncrement;
    }

    public String getBaseIncrement() {
        return this.baseIncrement;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getMinMarketFunds() {
        return this.minMarketFunds;
    }

    public String getMarginEnabled() {
        return this.marginEnabled;
    }

    public String getPostOnly() {
        return this.postOnly;
    }

    public String getLimitOnly() {
        return this.limitOnly;
    }

    public String getCancelOnly() {
        return this.cancelOnly;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public String getTradingDisabled() {
        return this.tradingDisabled;
    }

    public String getFxStablecoin() {
        return this.fxStablecoin;
    }

    public String getMaxSlippagePercentage() {
        return this.maxSlippagePercentage;
    }

    public String getAuctionMode() {
        return this.auctionMode;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$baseCurrency = this.getBaseCurrency();
        final Object other$baseCurrency = other.getBaseCurrency();
        if (this$baseCurrency == null ? other$baseCurrency != null : !this$baseCurrency.equals(other$baseCurrency))
            return false;
        final Object this$quoteCurrency = this.getQuoteCurrency();
        final Object other$quoteCurrency = other.getQuoteCurrency();
        if (this$quoteCurrency == null ? other$quoteCurrency != null : !this$quoteCurrency.equals(other$quoteCurrency))
            return false;
        final Object this$quoteIncrement = this.getQuoteIncrement();
        final Object other$quoteIncrement = other.getQuoteIncrement();
        if (this$quoteIncrement == null ? other$quoteIncrement != null : !this$quoteIncrement.equals(other$quoteIncrement))
            return false;
        final Object this$baseIncrement = this.getBaseIncrement();
        final Object other$baseIncrement = other.getBaseIncrement();
        if (this$baseIncrement == null ? other$baseIncrement != null : !this$baseIncrement.equals(other$baseIncrement))
            return false;
        final Object this$displayName = this.getDisplayName();
        final Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName))
            return false;
        final Object this$minMarketFunds = this.getMinMarketFunds();
        final Object other$minMarketFunds = other.getMinMarketFunds();
        if (this$minMarketFunds == null ? other$minMarketFunds != null : !this$minMarketFunds.equals(other$minMarketFunds))
            return false;
        final Object this$marginEnabled = this.getMarginEnabled();
        final Object other$marginEnabled = other.getMarginEnabled();
        if (this$marginEnabled == null ? other$marginEnabled != null : !this$marginEnabled.equals(other$marginEnabled))
            return false;
        final Object this$postOnly = this.getPostOnly();
        final Object other$postOnly = other.getPostOnly();
        if (this$postOnly == null ? other$postOnly != null : !this$postOnly.equals(other$postOnly)) return false;
        final Object this$limitOnly = this.getLimitOnly();
        final Object other$limitOnly = other.getLimitOnly();
        if (this$limitOnly == null ? other$limitOnly != null : !this$limitOnly.equals(other$limitOnly)) return false;
        final Object this$cancelOnly = this.getCancelOnly();
        final Object other$cancelOnly = other.getCancelOnly();
        if (this$cancelOnly == null ? other$cancelOnly != null : !this$cancelOnly.equals(other$cancelOnly))
            return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$statusMessage = this.getStatusMessage();
        final Object other$statusMessage = other.getStatusMessage();
        if (this$statusMessage == null ? other$statusMessage != null : !this$statusMessage.equals(other$statusMessage))
            return false;
        final Object this$tradingDisabled = this.getTradingDisabled();
        final Object other$tradingDisabled = other.getTradingDisabled();
        if (this$tradingDisabled == null ? other$tradingDisabled != null : !this$tradingDisabled.equals(other$tradingDisabled))
            return false;
        final Object this$fxStablecoin = this.getFxStablecoin();
        final Object other$fxStablecoin = other.getFxStablecoin();
        if (this$fxStablecoin == null ? other$fxStablecoin != null : !this$fxStablecoin.equals(other$fxStablecoin))
            return false;
        final Object this$maxSlippagePercentage = this.getMaxSlippagePercentage();
        final Object other$maxSlippagePercentage = other.getMaxSlippagePercentage();
        if (this$maxSlippagePercentage == null ? other$maxSlippagePercentage != null : !this$maxSlippagePercentage.equals(other$maxSlippagePercentage))
            return false;
        final Object this$auctionMode = this.getAuctionMode();
        final Object other$auctionMode = other.getAuctionMode();
        if (this$auctionMode == null ? other$auctionMode != null : !this$auctionMode.equals(other$auctionMode))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $baseCurrency = this.getBaseCurrency();
        result = result * PRIME + ($baseCurrency == null ? 43 : $baseCurrency.hashCode());
        final Object $quoteCurrency = this.getQuoteCurrency();
        result = result * PRIME + ($quoteCurrency == null ? 43 : $quoteCurrency.hashCode());
        final Object $quoteIncrement = this.getQuoteIncrement();
        result = result * PRIME + ($quoteIncrement == null ? 43 : $quoteIncrement.hashCode());
        final Object $baseIncrement = this.getBaseIncrement();
        result = result * PRIME + ($baseIncrement == null ? 43 : $baseIncrement.hashCode());
        final Object $displayName = this.getDisplayName();
        result = result * PRIME + ($displayName == null ? 43 : $displayName.hashCode());
        final Object $minMarketFunds = this.getMinMarketFunds();
        result = result * PRIME + ($minMarketFunds == null ? 43 : $minMarketFunds.hashCode());
        final Object $marginEnabled = this.getMarginEnabled();
        result = result * PRIME + ($marginEnabled == null ? 43 : $marginEnabled.hashCode());
        final Object $postOnly = this.getPostOnly();
        result = result * PRIME + ($postOnly == null ? 43 : $postOnly.hashCode());
        final Object $limitOnly = this.getLimitOnly();
        result = result * PRIME + ($limitOnly == null ? 43 : $limitOnly.hashCode());
        final Object $cancelOnly = this.getCancelOnly();
        result = result * PRIME + ($cancelOnly == null ? 43 : $cancelOnly.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $statusMessage = this.getStatusMessage();
        result = result * PRIME + ($statusMessage == null ? 43 : $statusMessage.hashCode());
        final Object $tradingDisabled = this.getTradingDisabled();
        result = result * PRIME + ($tradingDisabled == null ? 43 : $tradingDisabled.hashCode());
        final Object $fxStablecoin = this.getFxStablecoin();
        result = result * PRIME + ($fxStablecoin == null ? 43 : $fxStablecoin.hashCode());
        final Object $maxSlippagePercentage = this.getMaxSlippagePercentage();
        result = result * PRIME + ($maxSlippagePercentage == null ? 43 : $maxSlippagePercentage.hashCode());
        final Object $auctionMode = this.getAuctionMode();
        result = result * PRIME + ($auctionMode == null ? 43 : $auctionMode.hashCode());
        return result;
    }

    public String toString() {
        return "Product(id=" + this.getId() + ", baseCurrency=" + this.getBaseCurrency() + ", quoteCurrency=" + this.getQuoteCurrency() + ", quoteIncrement=" + this.getQuoteIncrement() + ", baseIncrement=" + this.getBaseIncrement() + ", displayName=" + this.getDisplayName() + ", minMarketFunds=" + this.getMinMarketFunds() + ", marginEnabled=" + this.getMarginEnabled() + ", postOnly=" + this.getPostOnly() + ", limitOnly=" + this.getLimitOnly() + ", cancelOnly=" + this.getCancelOnly() + ", status=" + this.getStatus() + ", statusMessage=" + this.getStatusMessage() + ", tradingDisabled=" + this.getTradingDisabled() + ", fxStablecoin=" + this.getFxStablecoin() + ", maxSlippagePercentage=" + this.getMaxSlippagePercentage() + ", auctionMode=" + this.getAuctionMode() + ")";
    }

    public static class ProductBuilder {
        private String id;
        private String baseCurrency;
        private String quoteCurrency;
        private String quoteIncrement;
        private String baseIncrement;
        private String displayName;
        private String minMarketFunds;
        private String marginEnabled;
        private String postOnly;
        private String limitOnly;
        private String cancelOnly;
        private String status;
        private String statusMessage;
        private String tradingDisabled;
        private String fxStablecoin;
        private String maxSlippagePercentage;
        private String auctionMode;

        ProductBuilder() {
        }

        public ProductBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ProductBuilder baseCurrency(String baseCurrency) {
            this.baseCurrency = baseCurrency;
            return this;
        }

        public ProductBuilder quoteCurrency(String quoteCurrency) {
            this.quoteCurrency = quoteCurrency;
            return this;
        }

        public ProductBuilder quoteIncrement(String quoteIncrement) {
            this.quoteIncrement = quoteIncrement;
            return this;
        }

        public ProductBuilder baseIncrement(String baseIncrement) {
            this.baseIncrement = baseIncrement;
            return this;
        }

        public ProductBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public ProductBuilder minMarketFunds(String minMarketFunds) {
            this.minMarketFunds = minMarketFunds;
            return this;
        }

        public ProductBuilder marginEnabled(String marginEnabled) {
            this.marginEnabled = marginEnabled;
            return this;
        }

        public ProductBuilder postOnly(String postOnly) {
            this.postOnly = postOnly;
            return this;
        }

        public ProductBuilder limitOnly(String limitOnly) {
            this.limitOnly = limitOnly;
            return this;
        }

        public ProductBuilder cancelOnly(String cancelOnly) {
            this.cancelOnly = cancelOnly;
            return this;
        }

        public ProductBuilder status(String status) {
            this.status = status;
            return this;
        }

        public ProductBuilder statusMessage(String statusMessage) {
            this.statusMessage = statusMessage;
            return this;
        }

        public ProductBuilder tradingDisabled(String tradingDisabled) {
            this.tradingDisabled = tradingDisabled;
            return this;
        }

        public ProductBuilder fxStablecoin(String fxStablecoin) {
            this.fxStablecoin = fxStablecoin;
            return this;
        }

        public ProductBuilder maxSlippagePercentage(String maxSlippagePercentage) {
            this.maxSlippagePercentage = maxSlippagePercentage;
            return this;
        }

        public ProductBuilder auctionMode(String auctionMode) {
            this.auctionMode = auctionMode;
            return this;
        }

        public Product build() {
            return new Product(id, baseCurrency, quoteCurrency, quoteIncrement, baseIncrement, displayName, minMarketFunds, marginEnabled, postOnly, limitOnly, cancelOnly, status, statusMessage, tradingDisabled, fxStablecoin, maxSlippagePercentage, auctionMode);
        }

        public String toString() {
            return "Product.ProductBuilder(id=" + this.id + ", baseCurrency=" + this.baseCurrency + ", quoteCurrency=" + this.quoteCurrency + ", quoteIncrement=" + this.quoteIncrement + ", baseIncrement=" + this.baseIncrement + ", displayName=" + this.displayName + ", minMarketFunds=" + this.minMarketFunds + ", marginEnabled=" + this.marginEnabled + ", postOnly=" + this.postOnly + ", limitOnly=" + this.limitOnly + ", cancelOnly=" + this.cancelOnly + ", status=" + this.status + ", statusMessage=" + this.statusMessage + ", tradingDisabled=" + this.tradingDisabled + ", fxStablecoin=" + this.fxStablecoin + ", maxSlippagePercentage=" + this.maxSlippagePercentage + ", auctionMode=" + this.auctionMode + ")";
        }
    }
}
