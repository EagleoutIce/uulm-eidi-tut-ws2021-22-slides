# allows me to use brace expansions
SHELL := /usr/bin/env bash

# requires:
# rename, pdftk and pdfsplitter (https://github.com/EagleoutIce/pdfsplitter)
# LaTeX: https://github.com/EagleoutIce

TUTS := $(wildcard *-Tutorium)
TUTS_CLEAN := $(TUTS:=-clean)
TARGET_DIR := all_pdfs
VERBOSE := 0

all: retrieve_pdfs
	echo -e "\033[32mRun for: $(TUTS)\033[m"

retrieve_pdfs: $(TUTS)
	# We want to retrieve the pdfs so we can split them afterwards
	mkdir -p $(TARGET_DIR)/animated
	cp *-Tutorium/folien_*.pdf $(TARGET_DIR)/animated/
	cp *-Tutorium/noanim_folien_*.pdf $(TARGET_DIR)/
	# rename them so they are easier to read ($$ escapes for makefile '\' for bash)
	rename -f "s/folien_([^.]*)\.pdf/eidi_tut_\$$1.pdf/" $(TARGET_DIR)/animated/folien_*.pdf
	rename -f "s/noanim_folien_([^.]*)\.pdf/eidi_tut_\$$1.pdf/" $(TARGET_DIR)/noanim_folien_*.pdf
	# Now we have to invoke the splitting for the pdfs using pdftk as cpdf is commercial
	# see: https://github.com/EagleoutIce/pdfsplitter
	# pdfsplitter -t 4 -c 89 -f -o "$(TARGET_DIR)/animated/{basename}_parts" $(TARGET_DIR)/animated/eidi_tut_*.pdf

$(TUTS):
	+echo "Building: '$@'"
	+$(MAKE) --jobs=2 --directory="$@" all

$(TUTS_CLEAN):
	+echo "Cleaning: '$(@:-clean=)'"
	+$(MAKE) -C "$(@:-clean=)" clean

clean: $(TUTS_CLEAN)
	echo "Deleting the '$(TARGET_DIR)'-dir"
	rm -rI $(TARGET_DIR)

.PHONY: all clean retrieve_pdfs $(TUTS) $(TUTS_CLEAN)

ifeq ($(VERBOSE),0)
MAKEFLAGS += --silent
# Better than defining '.SILENT'
endif
