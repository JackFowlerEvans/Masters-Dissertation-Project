import os
from lxml import etree
import re


def parse_vyos_config(config_lines):

    config_dict = {}
    stack = [config_dict]
    current_dict = config_dict

    for line in config_lines:
        stripped_line = line.strip()
        if not stripped_line or stripped_line.startswith("//") or stripped_line.startswith("#"):
            continue  # Skip empty lines and comments

        if stripped_line.endswith('{'):
            key = stripped_line[:-1].strip()
            if key not in current_dict:
                current_dict[key] = {}
            stack.append(current_dict)
            current_dict = current_dict[key]
        elif stripped_line == '}':
            current_dict = stack.pop()
        else:
            key_value = stripped_line.split(None, 1)
            key = key_value[0]
            value = key_value[1] if len(key_value) > 1 else ''
            current_dict[key] = value

    return config_dict


def sanitize_tag(tag):

    return re.sub(r'[^a-zA-Z0-9_-]', '_', tag)


def dict_to_xml(tag, d):

    elem = etree.Element(sanitize_tag(tag))
    for key, val in d.items():
        child = etree.SubElement(elem, sanitize_tag(key))
        if isinstance(val, dict):
            child.append(dict_to_xml(key, val))
        else:
            child.text = str(val) if val is not None else ''
    return elem


def config_to_xml(config_text):

    config_lines = config_text.splitlines()
    config_dict = parse_vyos_config(config_lines)

    root = dict_to_xml('vyos_config', config_dict)
    xml_str = etree.tostring(root, pretty_print=True, encoding='unicode')

    return xml_str


def convert_config_to_xml():
    data_folder = os.path.join(os.path.dirname(__file__), 'data_folder')
    config_file = os.path.join(data_folder, 'vyos')
    xml_output_file = os.path.join(data_folder, 'config.xml')

    # Read the config file
    with open(config_file, 'r') as file:
        config_data = file.read()

    # Convert the pulled config to XML
    xml_data = config_to_xml(config_data)

    # Store the XML data to a file
    with open(xml_output_file, 'w') as file:
        file.write(xml_data)

    print(f"Configuration has been converted to XML and stored in: {xml_output_file}")


"""if __name__ == "__main__":
    main()"""
