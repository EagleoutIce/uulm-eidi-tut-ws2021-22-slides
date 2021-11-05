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
	# custom rename :D
	rename "s/folien_([^.]*)\.pdf/eidi_tut_\1.pdf/" "$(TARGET_DIR)/animated/folien_*.pdf"
	rename "s/noanim_folien_([^.]*)\.pdf/eidi_tut_\1.pdf/" "$(TARGET_DIR)/noanim_folien_*.pdf"

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

docker:
	docker build -t 'eidi-ws2021-tut-make' -f 'Dockerfile' .

ifeq ($(VERBOSE),0)
MAKEFLAGS += --silent
# Better than defining '.SILENT'
endif
