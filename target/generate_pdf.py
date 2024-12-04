import sys
sys.path.insert(0, r"G:\Work\grammarinator_ucla_cs230\target\xhtml2pdf")

import argparse
from xhtml2pdf import pisa
import os

def convert_html_to_pdf(input_html_file, output_pdf_file):
    """Converts an HTML file to a PDF file."""
    # Read the HTML file
    with open(input_html_file, "r") as html_file:
        html_content = html_file.read()

    # Convert HTML to PDF
    with open(output_pdf_file, "wb") as pdf_file:
        pisa_status = pisa.CreatePDF(html_content, dest=pdf_file)

    # Check for errors
    if pisa_status.err:
        print("Error occurred while generating PDF.")
    else:
        print(f"PDF successfully generated: {output_pdf_file}")

def main():
    # Parse command-line arguments
    parser = argparse.ArgumentParser(description="Convert HTML to PDF using xhtml2pdf.")
    parser.add_argument("input_html", help="Path to the input HTML file")
    args = parser.parse_args()

    # Derive the output PDF file name
    input_html_path = args.input_html
    output_pdf_path = os.path.splitext(input_html_path)[0] + ".pdf"

    # Convert HTML to PDF
    print(input_html_path, output_pdf_path)
    convert_html_to_pdf(input_html_path, output_pdf_path)

main()
