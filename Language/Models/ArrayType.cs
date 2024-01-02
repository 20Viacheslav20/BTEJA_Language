using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Language.Models
{
    public class ArrayType
    {
        public DataType Type { get; set; }
        public int Size { get; set; }

        public ArrayType(DataType type, int size)
        {
            Type = type;
            Size = size;
        }
    }
}
