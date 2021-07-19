package domain.model;

public enum Province {
	AC,
	AL,
	AM,
	AP,
	BA,
	CE,
	DF,
	ES,
	GO,
	MA,
	MG,
	MS,
	MT,
	PA,
	PB,
	PE,
	PI,
	PR {
		@Override
		public boolean isWarrantyAccepted() {
			return false;
		}
	},
	RJ,
	RN,
	RO,
	RR,
	RS {
		@Override
		public boolean isWarrantyAccepted() {
			return false;
		}
	},
	SC {
		@Override
		public boolean isWarrantyAccepted() {
			return false;
		}
	},
	SE,
	SP,
	TO;

	public boolean isWarrantyAccepted() {
		return true;
	}
}