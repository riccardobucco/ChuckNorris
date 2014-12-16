DOCUMENTI = NormeDiProgetto


all: $(DOCUMENTI)


$(DOCUMENTI): FORCE
	@ #validazione schema
	@ xmllint --noout --schema Commons/document.xsd $@/$@.xml

	@ #creazione file latex
	@ xsltproc -o $@/$@.tex Commons/document.xsl $@/$@.xml

	@ #compilazione file latex
	@ export TEXINPUTS=":Commons/:$@/"; pdflatex -output-directory $@ $@/$@.tex
	@ export TEXINPUTS=":Commons/:$@/"; pdflatex -output-directory $@ $@/$@.tex > /dev/null
	@ export TEXINPUTS=":Commons/:$@/"; pdflatex -output-directory $@ $@/$@.tex > /dev/null
	

clean: FORCE
	@ #file generati da pdflatex
	@ $(foreach doc, $(DOCUMENTI), rm -f $(doc)/$(doc).tex $(doc)/*.aux $(doc)/*.out $(doc)/*.toc $(doc)/*.log $(doc)/*.pdf)

FORCE: