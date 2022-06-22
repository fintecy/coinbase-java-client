package org.fintecy.md.coinbase.model;

import java.util.Set;

public class Currency extends MicroType<String> implements Comparable<Currency> {
    private final String name;
    private final String minSize;
    private final CurrencyStatus status;
    private final String message;
    private final String maxPrecision;
    private final Set<Object> convertibleTo;
    private final CurrencyDetails details;
    private final CryptoNetworkName defaultNetwork;
    private final Set<CryptoNetwork> supportedNetwork;

    public Currency(String id, String name, String minSize, CurrencyStatus status, String message, String maxPrecision,
                    Set<Object> convertibleTo, CurrencyDetails details, CryptoNetworkName defaultNetwork,
                    Set<CryptoNetwork> supportedNetwork) {
        super(id);
        this.name = name;
        this.minSize = minSize;
        this.status = status;
        this.message = message;
        this.maxPrecision = maxPrecision;
        this.convertibleTo = convertibleTo;
        this.details = details;
        this.defaultNetwork = defaultNetwork;
        this.supportedNetwork = supportedNetwork;
    }

    public static Currency currency(String id, String name, String status) {
        return new Currency(id, name, null, new CurrencyStatus(status), null, "0.00000001",
                Set.of(), null, CryptoNetworkName.ETHEREUM, null);
    }
    public static Currency currency(String code) {
        return new Currency(code, code, null, CurrencyStatus.ONLINE, null, "0.00000001",
                Set.of(), null, CryptoNetworkName.ETHEREUM, null);
    }

    public static Currency fromJavaCurrency(java.util.Currency currency) {
        return currency(currency.getCurrencyCode());
    }

    public static CurrencyBuilder builder() {
        return new CurrencyBuilder();
    }

    public java.util.Currency toJavaCurrency() {
        return java.util.Currency.getInstance(value);
    }

    public String getCode() {
        return value;
    }

    @Override
    public int compareTo(Currency o) {
        return value.compareTo(o.value);
    }

    public String getName() {
        return this.name;
    }

    public String getMinSize() {
        return this.minSize;
    }

    public CurrencyStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMaxPrecision() {
        return this.maxPrecision;
    }

    public Set<Object> getConvertibleTo() {
        return this.convertibleTo;
    }

    public CurrencyDetails getDetails() {
        return this.details;
    }

    public CryptoNetworkName getDefaultNetwork() {
        return this.defaultNetwork;
    }

    public Set<CryptoNetwork> getSupportedNetwork() {
        return this.supportedNetwork;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Currency)) return false;
        final Currency other = (Currency) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$minSize = this.getMinSize();
        final Object other$minSize = other.getMinSize();
        if (this$minSize == null ? other$minSize != null : !this$minSize.equals(other$minSize)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final Object this$maxPrecision = this.getMaxPrecision();
        final Object other$maxPrecision = other.getMaxPrecision();
        if (this$maxPrecision == null ? other$maxPrecision != null : !this$maxPrecision.equals(other$maxPrecision))
            return false;
        final Object this$convertibleTo = this.getConvertibleTo();
        final Object other$convertibleTo = other.getConvertibleTo();
        if (this$convertibleTo == null ? other$convertibleTo != null : !this$convertibleTo.equals(other$convertibleTo))
            return false;
        final Object this$details = this.getDetails();
        final Object other$details = other.getDetails();
        if (this$details == null ? other$details != null : !this$details.equals(other$details)) return false;
        final Object this$defaultNetwork = this.getDefaultNetwork();
        final Object other$defaultNetwork = other.getDefaultNetwork();
        if (this$defaultNetwork == null ? other$defaultNetwork != null : !this$defaultNetwork.equals(other$defaultNetwork))
            return false;
        final Object this$supportedNetwork = this.getSupportedNetwork();
        final Object other$supportedNetwork = other.getSupportedNetwork();
        if (this$supportedNetwork == null ? other$supportedNetwork != null : !this$supportedNetwork.equals(other$supportedNetwork))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Currency;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $minSize = this.getMinSize();
        result = result * PRIME + ($minSize == null ? 43 : $minSize.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $maxPrecision = this.getMaxPrecision();
        result = result * PRIME + ($maxPrecision == null ? 43 : $maxPrecision.hashCode());
        final Object $convertibleTo = this.getConvertibleTo();
        result = result * PRIME + ($convertibleTo == null ? 43 : $convertibleTo.hashCode());
        final Object $details = this.getDetails();
        result = result * PRIME + ($details == null ? 43 : $details.hashCode());
        final Object $defaultNetwork = this.getDefaultNetwork();
        result = result * PRIME + ($defaultNetwork == null ? 43 : $defaultNetwork.hashCode());
        final Object $supportedNetwork = this.getSupportedNetwork();
        result = result * PRIME + ($supportedNetwork == null ? 43 : $supportedNetwork.hashCode());
        return result;
    }

    public String toString() {
        return "Currency(name=" + this.getName() + ", minSize=" + this.getMinSize() + ", status=" + this.getStatus() + ", message=" + this.getMessage() + ", maxPrecision=" + this.getMaxPrecision() + ", convertibleTo=" + this.getConvertibleTo() + ", details=" + this.getDetails() + ", defaultNetwork=" + this.getDefaultNetwork() + ", supportedNetwork=" + this.getSupportedNetwork() + ")";
    }

    public static class CurrencyBuilder {
        private String id;
        private String name;
        private String minSize;
        private CurrencyStatus status;
        private String message;
        private String maxPrecision;
        private Set<Object> convertibleTo;
        private CurrencyDetails details;
        private CryptoNetworkName defaultNetwork;
        private Set<CryptoNetwork> supportedNetwork;

        CurrencyBuilder() {
        }

        public CurrencyBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CurrencyBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CurrencyBuilder minSize(String minSize) {
            this.minSize = minSize;
            return this;
        }

        public CurrencyBuilder status(CurrencyStatus status) {
            this.status = status;
            return this;
        }

        public CurrencyBuilder message(String message) {
            this.message = message;
            return this;
        }

        public CurrencyBuilder maxPrecision(String maxPrecision) {
            this.maxPrecision = maxPrecision;
            return this;
        }

        public CurrencyBuilder convertibleTo(Set<Object> convertibleTo) {
            this.convertibleTo = convertibleTo;
            return this;
        }

        public CurrencyBuilder details(CurrencyDetails details) {
            this.details = details;
            return this;
        }

        public CurrencyBuilder defaultNetwork(CryptoNetworkName defaultNetwork) {
            this.defaultNetwork = defaultNetwork;
            return this;
        }

        public CurrencyBuilder supportedNetwork(Set<CryptoNetwork> supportedNetwork) {
            this.supportedNetwork = supportedNetwork;
            return this;
        }

        public Currency build() {
            return new Currency(id ,name, minSize, status, message, maxPrecision, convertibleTo, details, defaultNetwork, supportedNetwork);
        }

        public String toString() {
            return "Currency.CurrencyBuilder(name=" + this.name + ", minSize=" + this.minSize + ", status=" + this.status + ", message=" + this.message + ", maxPrecision=" + this.maxPrecision + ", convertibleTo=" + this.convertibleTo + ", details=" + this.details + ", defaultNetwork=" + this.defaultNetwork + ", supportedNetwork=" + this.supportedNetwork + ")";
        }
    }
}
